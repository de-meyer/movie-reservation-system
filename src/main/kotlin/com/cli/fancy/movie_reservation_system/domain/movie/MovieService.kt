package com.cli.fancy.movie_reservation_system.domain.movie

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieResponse
import com.cli.fancy.movie_reservation_system.application.movie.mapper.MovieMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import java.util.*

@Service
class MovieService(val movieRepository: MovieRepository, val movieMapper: MovieMapper) {
    fun getAllMovies(): Flux<Movie> = movieRepository.findAll()
        .map { movieMapper.toMovieFromEntity(it) }
        .toFlux()

    fun getMovieById(id: UUID): Mono<Movie> =
        movieRepository.findById(id)
            .switchIfEmpty(Mono.error(NoSuchElementException("FIND: Movie not found with id: $id")))
            .map { movieMapper.toMovieFromEntity(it) }

    fun updateMovie(movie: MovieResponse): Mono<Movie> =
        movieRepository.findById(movie.id)
            .switchIfEmpty(Mono.error(NoSuchElementException("UPDATE: Movie not found with id: $id")))
            .flatMap { existingEntity ->
                val updatedEntity = existingEntity.copy(
                    title = movie.title,
                    description = movie.description,
                    releaseYear = movie.releaseYear,
                    director = movie.director,
                    genre = movie.genre,
                    durationMinutes = movie.durationMinutes,
                    rating = movie.rating,
                    imageProfile = movie.imageProfile,
                    imageLandscape = movie.imageLandscape
                )
                movieRepository.save(updatedEntity)
            }
            .map { movieMapper.toMovieFromEntity(it) }


}