package com.cli.fancy.movie_reservation_system.application.show.dto

import java.time.Instant
import java.util.*

data class ShowCreateRequest(
    val movieId: UUID,
    val theaterId: UUID,
    val date: Instant,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ShowCreateRequest) return false

        if (movieId != other.movieId) return false
        if (theaterId != other.theaterId) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = movieId.hashCode()
        result = 31 * result + theaterId.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}