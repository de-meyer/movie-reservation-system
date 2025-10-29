package com.cli.fancy.movie_reservation_system.application.program.dto

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.theater.Theater

data class ProgramResponse(
    val shows: Collection<ShowResponse>,
    val movie: Movie,
    val theaters: Collection<Theater>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProgramResponse) return false

        if (shows != other.shows) return false
        if (movie != other.movie) return false
        if (theaters != other.theaters) return false

        return true
    }

    override fun hashCode(): Int {
        var result = shows.hashCode()
        result = 31 * result + movie.hashCode()
        result = 31 * result + theaters.hashCode()
        return result
    }
}