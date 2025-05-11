package com.cli.fancy.movie_reservation_system.domain.movie

import com.cli.fancy.movie_reservation_system.application.movie.Movie
import com.cli.fancy.movie_reservation_system.application.movie.MovieController
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseInformationDTO
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MovieService(val movieRepository: MovieRepository) {
    fun getAllMovies(): List<MovieBrowseInformationDTO> = movieRepository.findAll()
        .map { it.toBrowseInformationDTO() }
        .toList()
    fun getMovieById(id: UUID): Movie? {
        val movieEntity = movieRepository.findById(id)
        return if (movieEntity.isPresent) {
            movieEntity.get().toDto()
        } else {
            null
        }
    }
    private fun MovieEntity.toBrowseInformationDTO() = MovieBrowseInformationDTO (
       name = this.title,
        image = this.image,
        url = "movie/${this.id}"
    )
    private fun MovieEntity.toDto() = Movie(
        id = this.id,
        title = this.title,
        genre = this.genre,
        durationMinutes = this.durationMinutes!!,
        releaseYear = this.releaseYear,
        rating = this.rating,
        description = this.description!!,
        director = this.director,
        image = this.image,
    )
    private fun Movie.toEntity() = MovieEntity(
        id = this.id,
        title = this.title,
        genre = this.genre,
        durationMinutes = this.durationMinutes,
        releaseYear = this.releaseYear,
        rating = this.rating,
        description = this.description,
        image = this.image,
    )
}