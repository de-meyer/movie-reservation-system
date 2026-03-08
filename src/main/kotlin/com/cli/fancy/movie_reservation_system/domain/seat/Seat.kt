package com.cli.fancy.movie_reservation_system.domain.seat

import java.util.*

data class Seat(
    val id: UUID,
    val row: String,
    val number: Int,
)