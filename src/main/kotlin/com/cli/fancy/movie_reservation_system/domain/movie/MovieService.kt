package com.cli.fancy.movie_reservation_system.domain.movie

import com.cli.fancy.movie_reservation_system.application.movie.mapper.MovieMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MovieService(val movieRepository: MovieRepository, val movieMapper: MovieMapper) {
    fun getAllMovies(): List<MovieBrowserInformation> = movieRepository.findAll()
        .map { movieMapper.toBrowserInformationDomain(it) }
        .toList()

    fun getMovieById(id: UUID): Movie? {
        val movieEntity = movieRepository.findById(id)
        return if (movieEntity.isPresent) {
            movieMapper.toMovie(movieEntity.get())
        } else {
            null
        }
    }
}