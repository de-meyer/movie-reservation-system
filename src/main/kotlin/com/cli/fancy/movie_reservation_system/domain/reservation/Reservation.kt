package com.cli.fancy.movie_reservation_system.domain.reservation

import java.util.UUID

data class Reservation(
    val id: UUID? = null,
    val userId: String,
    val theaterId: String,
    val seatNumber: Int,
    val movieId: String,
    val date: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Reservation) return false

        if (seatNumber != other.seatNumber) return false
        if (id != other.id) return false
        if (userId != other.userId) return false
        if (theaterId != other.theaterId) return false
        if (movieId != other.movieId) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = seatNumber
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + userId.hashCode()
        result = 31 * result + theaterId.hashCode()
        result = 31 * result + movieId.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
