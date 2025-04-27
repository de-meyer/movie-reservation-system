package com.cli.fancy.movie_reservation_system.domain.movie

import com.cli.fancy.movie_reservation_system.application.movie.Movie
import com.cli.fancy.movie_reservation_system.application.movie.MovieController
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(val movieRepository: MovieRepository) {
    fun getAllMovies(): List<Movie> = movieRepository.findAll()
        .map { it.toDto() }
        .toList()

    private fun MovieEntity.toDto() = Movie(
        id = this.id,
        title = this.title,
        genre = this.genre!!,
        duration = this.durationMinutes!!,
        releaseYear = this.releaseYear!!,
        rating = this.rating!!,
        description = this.description!!
    )
    private fun Movie.toEntity() = MovieEntity(
        id = this.id,
        title = this.title,
        genre = this.genre,
        durationMinutes = this.duration,
        releaseYear = this.releaseYear,
        rating = this.rating,
        description = this.description
    )
}