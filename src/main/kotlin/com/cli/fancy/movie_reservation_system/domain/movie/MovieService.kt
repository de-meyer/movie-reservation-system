package com.cli.fancy.movie_reservation_system.domain.movie

import com.cli.fancy.movie_reservation_system.application.auth.OAuthLoginRequest
import com.cli.fancy.movie_reservation_system.application.movie.Movie
import com.cli.fancy.movie_reservation_system.application.movie.MovieController
import com.cli.fancy.movie_reservation_system.application.user.User
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.UserEntity
import org.springframework.stereotype.Service

@Service
class MovieService(val movieController: MovieController) {
    fun getAllMovies(): List<Movie> = movieController.getAllMovies()
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