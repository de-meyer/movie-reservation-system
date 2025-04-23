package com.cli.fancy.movie_reservation_system.application.movie

import java.util.UUID

data class Movie(
    val id: UUID? = null,
    val title: String,
    val description: String,
    val duration: Int,
    val genre: String,
    val releaseYear: Int,
    val rating: Double,
)
