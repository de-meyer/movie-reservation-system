package com.cli.fancy.movie_reservation_system.application.movie.dto

data class MovieCreationRequest(
    val title: String,
    val description: String,
    val durationMinutes: Int,
    val director: String,
    val genre: String,
    val releaseYear: Int,
    val imageProfile: String,
    val imageLandscape: String
)
