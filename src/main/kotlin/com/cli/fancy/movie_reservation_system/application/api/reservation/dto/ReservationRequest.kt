package com.cli.fancy.movie_reservation_system.application.api.reservation.dto

import java.time.Instant
import java.util.*

data class ReservationRequest(
    val userId: UUID, val theaterId: UUID, val seatNumber: Int,
    val movieId: UUID, val date: Instant
)