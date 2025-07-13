package com.cli.fancy.movie_reservation_system.application.reservation.dto

import java.time.Instant
import java.time.LocalDate
import java.util.UUID

data class ReservationRequest(
    val userId: UUID, val theaterId: UUID, val seatNumber: Int,
    val movieId: UUID, val date: Instant
) {
}
