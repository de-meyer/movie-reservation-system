package com.cli.fancy.movie_reservation_system.application.api.reservation.dto

import java.util.*

data class ReservationResponse(
    val reservationId: UUID,
    val movieId: UUID,
    val seatNumber: Int,
    val userId: UUID,
)