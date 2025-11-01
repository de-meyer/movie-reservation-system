package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.movie.mapper.MovieMapper
import com.cli.fancy.movie_reservation_system.application.program.mapper.ProgramMapper
import com.cli.fancy.movie_reservation_system.application.show.mapper.ShowMapper
import com.cli.fancy.movie_reservation_system.application.theater.mapper.TheaterMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
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

    fun getProgramList(): List<Program> {
        val showsEntity = showRepository.findAll().toList()
        if (showsEntity.isEmpty()) {
            return emptyList()
        }
        val shows = showsEntity.map { showMapper.toShow(it) }

        // Get all movies related to the shows
        val movieIds = showsEntity.map { it.movieId }.toSet()
        val moviesEntity = movieReository.findAllById(movieIds).toList()
        val movies = moviesEntity.map { movieMapper.toMovie(it) }

        // Get all theaters related to the shows
        val theaterIds = showsEntity.map { it.theaterId }.toList()
        val theatersEntity = theaterRepository.findAllById(theaterIds).toList()
        val theaters = theatersEntity.map { theaterMapper.toTheater(it) }



        return shows.mapNotNull { show ->
            val movie = movies.find { it.id == show.movieId }
            val theater = theaters.find { it.id == show.theaterId }

            movie?.let { m ->
                theater?.let { t ->
                    Program.from(m, t, show)
                }
            }
        }
    }
}