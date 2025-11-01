package com.cli.fancy.movie_reservation_system.application.program.dto

import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.show.ShowTime
import com.cli.fancy.movie_reservation_system.domain.theater.Theater

data class ProgramResponse(
    val movie: Movie,
    val theater: Theater,
    val showTime: ShowTime,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProgramResponse) return false

        if (movie != other.movie) return false
        if (theater != other.theater) return false
        if (showTime != other.showTime) return false

        return true
    }

    override fun hashCode(): Int {
        var result = movie.hashCode()
        result = 31 * result + theater.hashCode()
        result = 31 * result + showTime.hashCode()
        return result
    }
}