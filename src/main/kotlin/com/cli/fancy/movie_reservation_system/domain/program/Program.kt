package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.show.ShowSchedule

data class Program(
    val movie: Movie,
    val shows: List<ShowSchedule>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Program) return false

        if (movie != other.movie) return false
        if (shows != other.shows) return false

        return true
    }

    override fun hashCode(): Int {
        var result = movie.hashCode()
        result = 31 * result + shows.hashCode()
        return result
    }
}
