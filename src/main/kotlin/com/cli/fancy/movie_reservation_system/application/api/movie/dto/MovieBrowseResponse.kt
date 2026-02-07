package com.cli.fancy.movie_reservation_system.application.api.movie.dto

import java.util.*

data class MovieBrowseResponse(
    val title: String,
    val id: UUID
)