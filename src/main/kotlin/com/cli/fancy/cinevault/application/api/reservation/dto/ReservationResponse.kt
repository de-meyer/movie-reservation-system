package com.cli.fancy.cinevault.application.api.reservation.dto

import java.util.*

data class ReservationResponse(
    val reservationId: UUID,
    val movieId: UUID,
    val seatNumber: Int,
    val userId: UUID,
)
