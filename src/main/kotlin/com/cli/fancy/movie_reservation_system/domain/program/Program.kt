package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.show.Show
import com.cli.fancy.movie_reservation_system.domain.show.ShowTime
import com.cli.fancy.movie_reservation_system.domain.theater.Theater

data class Program(
    val movie: Movie,
    val theater: Theater,
    val showTime: ShowTime
) {

    companion object {
        fun from(movie: Movie, theater: Theater, show: Show): Program {
            return Program(
                movie = movie,
                theater = theater,
                showTime = ShowTime.from(show)
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Program) return false

        if (movie != other.movie) return false
        if (theater != other.theater) return false
        if (showTime != other.showTime) return false

        return true
    }

    override fun hashCode(): Int {
        var result = showTime.hashCode()
        result = 31 * result + movie.hashCode()
        result = 31 * result + theater.hashCode()
        return result
    }
}

