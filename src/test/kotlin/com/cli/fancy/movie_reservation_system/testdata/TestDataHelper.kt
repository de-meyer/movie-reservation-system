package com.cli.fancy.movie_reservation_system.testdata

import com.cli.fancy.movie_reservation_system.application.movie.mapper.toMovieFromEntity
import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TestDataHelper(private val movieRepository: MovieRepository) {
    fun createMovie(number: String = "1"): Movie = movieRepository.save(
        MovieEntity(
            title = "Movie $number",
            description = "foo bar $number",
            durationMinutes = 90,
            director = "Max Foo Bar $number",
            genre = "Comedy $number",
            releaseYear = 2025,
            imageProfile = "profile$number.jpg",
            imageLandscape = "Landscape$number.jpg"
        )

    ).block()!!.toMovieFromEntity()

    fun createMovieWithId(id: UUID) = movieRepository.save(
        MovieEntity(
            id = id,
            title = "Movie",
            description = "foo bar",
            durationMinutes = 90,
            director = "Max Foo Bar",
            genre = "Comedy",
            releaseYear = 2025,
            imageProfile = "profile.jpg",
            imageLandscape = "Landscape.jpg"
        )
    ).block()!!


    fun createMovies(count: Int): List<Movie> {
        return (1..count).map {
            createMovie(number = "$it")
        }
    }

}