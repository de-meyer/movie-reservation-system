package com.cli.fancy.movie_reservation_system.application.api.movie.dto

data class MovieForProgramResponse(
    val title: String,
    val description: String,
    val durationMinutes: Int,
    val director: String,
    val genre: String,
    val releaseYear: Int,
    val rating: Double?,
)
