package com.cli.fancy.cinevault.domain.reservation

import java.util.UUID

data class Reservation(
    val id: UUID? = null,
    val userId: UUID,
    val theaterId: UUID,
    val seatNumber: Int,
    val movieId: UUID,
)
