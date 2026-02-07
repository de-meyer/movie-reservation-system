package com.cli.fancy.movie_reservation_system.application.api.movie.dto

import java.util.*

data class MovieCreateShowResponse(
    val id: UUID,
    val title: String,
    val durationMinutes: Int
)