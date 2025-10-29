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
    val programMapper: ProgramMapper,
    val movieMapper: MovieMapper,
    val showMapper: ShowMapper,
    val theaterMapper: TheaterMapper
) {

    fun getPrograms(): List<Program> {
        val showsEntity = showRepository.findAll()
        val movieIds = showsEntity.map { it.movieId }.distinct()
        val moviesEntity = movieReository.findAllById(movieIds).toList()
        val theaterIds = showsEntity.map { it.theaterId }.distinct()
        val theatersEntity = theaterRepository.findAllById(theaterIds).toList()

        val shows = showsEntity.map { showMapper.toShow(it) }
        val movies = moviesEntity.map { movieMapper.toMovie(it) }
        val theaters = theatersEntity.map { theaterMapper.toTheater(it) }

        return movies.mapNotNull { movie ->
            val relatedShows = shows.filter { show -> show.movieId == movie.id }
            val theaterIds = relatedShows.map { it.theaterId }.toSet()
            val relatedTheaters = theaters.filter { it.id in theaterIds }
            programMapper.toProgram(relatedShows, movie, relatedTheaters)
        }
    }
}