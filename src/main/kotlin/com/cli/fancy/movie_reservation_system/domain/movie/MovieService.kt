package com.cli.fancy.movie_reservation_system.domain.movie

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreationRequest
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieResponse
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toEntity
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toMovieFromEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class MovieService(val movieRepository: MovieRepository) {
    fun getAllMovies(): Flux<Movie> = movieRepository.findAll()
        .switchIfEmpty(Mono.error(NoSuchElementException("No movies found")))
        .map { it.toMovieFromEntity() }


    fun getMovieById(id: UUID): Mono<Movie> =
        movieRepository.findById(id)
            .switchIfEmpty(Mono.error(NoSuchElementException("FIND: Movie not found with id: $id")))
            .map { it.toMovieFromEntity() }

    fun updateMovie(movie: MovieResponse): Mono<Movie> =
        movieRepository.findById(movie.id)
            .switchIfEmpty(Mono.error(NoSuchElementException("UPDATE: Movie not found with id: $movie.id")))
            .flatMap { existingEntity ->
                // TODO: find a better way than non null assertion !!
                val updatedEntity = existingEntity.copy(
                    title = movie.title,
                    description = movie.description,
                    releaseYear = movie.releaseYear,
                    director = movie.director!!,
                    genre = movie.genre!!,
                    durationMinutes = movie.durationMinutes,
                    imageProfile = movie.imageProfile!!,
                    imageLandscape = movie.imageLandscape!!
                )
                movieRepository.save(updatedEntity)
            }
            .map { it.toMovieFromEntity() }

    fun createMovieFromRequest(movieCreationRequest: MovieCreationRequest): Mono<Movie> =
        movieRepository.save(movieCreationRequest.toEntity())
            .map { it.toMovieFromEntity() }

}