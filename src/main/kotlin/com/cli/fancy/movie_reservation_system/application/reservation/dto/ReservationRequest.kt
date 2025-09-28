package com.cli.fancy.movie_reservation_system.application.reservation.dto

import java.time.Instant
import java.util.*

data class ReservationRequest(
    val userId: UUID, val theaterId: UUID, val seatNumber: Int,
    val movieId: UUID, val date: Instant
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ReservationRequest) return false

        if (seatNumber != other.seatNumber) return false
        if (userId != other.userId) return false
        if (theaterId != other.theaterId) return false
        if (movieId != other.movieId) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = seatNumber
        result = 31 * result + userId.hashCode()
        result = 31 * result + theaterId.hashCode()
        result = 31 * result + movieId.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
