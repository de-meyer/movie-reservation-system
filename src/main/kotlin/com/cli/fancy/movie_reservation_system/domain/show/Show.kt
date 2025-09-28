package com.cli.fancy.movie_reservation_system.domain.show

import java.time.Instant
import java.util.UUID

data class Show(
    val id: UUID? = null,
    val theaterId: UUID,
    val movieId: UUID,
    val date: Instant
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Show) return false

        if (id != other.id) return false
        if (theaterId != other.theaterId) return false
        if (movieId != other.movieId) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + theaterId.hashCode()
        result = 31 * result + movieId.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }

}
