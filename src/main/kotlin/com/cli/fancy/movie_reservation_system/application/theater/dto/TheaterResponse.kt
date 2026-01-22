package com.cli.fancy.movie_reservation_system.application.theater.dto

import java.util.UUID

class TheaterResponse(
    val id: UUID?,
    val name: String,
    val capacity: Number,
)