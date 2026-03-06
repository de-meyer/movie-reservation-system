package com.cli.fancy.movie_reservation_system.application.api.theater.dto

import java.util.UUID

class SeatResponse(
    val id: UUID,
    val row: String,
    val number: Int,
)
