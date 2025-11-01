package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.movie.mapper.MovieMapper
import com.cli.fancy.movie_reservation_system.application.show.mapper.ShowMapper
import com.cli.fancy.movie_reservation_system.application.theater.mapper.TheaterMapper
import com.cli.fancy.movie_reservation_system.domain.show.ShowSchedule
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service
class ProgramService(
    val movieReository: MovieRepository,
    val showRepository: ShowRepository,
    val theaterRepository: TheaterRepository,
    val movieMapper: MovieMapper,
    val showMapper: ShowMapper,
    val theaterMapper: TheaterMapper
) {

    fun getProgramList(page: Int, size: Int): Page<Program> {
        val pageable = PageRequest.of(page, size)
        val showsPage = showRepository.findAll(pageable)
        val showsEntity = showsPage.content
        if (showsEntity.isEmpty()) return Page.empty(pageable)

        val shows = showsEntity.map { showMapper.toShow(it) }

        // Get all movies related to the shows
        val movieIds = showsEntity.map { it.movieId }.toSet()
        val movies = movieReository.findAllById(movieIds)
            .map { movieMapper.toMovieFromEntity(it) }
            .associateBy { it.id }

        // Get all theaters related to the shows
        val theaterIds = showsEntity.map { it.theaterId }.toList()
        val theaters = theaterRepository.findAllById(theaterIds)
            .map { theaterMapper.toTheater(it) }
            .associateBy { it.id }

        val programs = shows.groupBy { it.movieId }.mapNotNull { (movieId, movieShows) ->
            val movie = movies[movieId] ?: return@mapNotNull null

            val showSchedules = movieShows.mapNotNull { show ->
                val theater = theaters[show.theaterId] ?: return@mapNotNull null
                ShowSchedule(
                    theaterName = theater.name,
                    date = show.date
                )
            }
            Program(
                movie = movie,
                shows = showSchedules
            )
        }
        return PageImpl(programs, pageable, showsPage.totalElements)

    }
}