package com.cli.fancy.movie_reservation_system.domain.movie

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieResponse
import com.cli.fancy.movie_reservation_system.application.movie.mapper.MovieMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import java.util.*

@Service
class MovieService(val movieRepository: MovieRepository, val movieMapper: MovieMapper) {
    fun getAllMovies(): Flux<Movie> = movieRepository.findAll()
        .map { movieMapper.toMovieFromEntity(it) }
        .toFlux()

    fun getMovieById(id: UUID): Mono<Movie> {
        val movieEntity = movieRepository.findById(id)
        return if (movieEntity.isPresent) {
            movieMapper.toMovieFromEntity(movieEntity.get())
        } else {
            null
        }
    }

    fun updateMovie(movie: MovieResponse): Movie {
        val movieEntity =
            movieRepository.findById(movie.id).orElseThrow { NoSuchElementException("Movie with id $id not found") }
        return movieMapper.toMovieFromEntity(movieRepository.save(movieEntity))
    }
}