package com.cli.fancy.movie_reservation_system.application.reservation.dto

import java.time.Instant
import java.util.UUID

data class ReservationResponse(
    val reservationId: UUID,
    val programId: UUID,
    val movieId: UUID,
    val seatNumber: String,
    val userId: UUID,
    val createdAt: Instant
) {
}