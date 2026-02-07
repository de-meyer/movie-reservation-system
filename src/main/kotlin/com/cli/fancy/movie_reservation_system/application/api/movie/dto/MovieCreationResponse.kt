package com.cli.fancy.movie_reservation_system.application.api.movie.dto

import java.util.*

data class MovieCreationResponse(
    val id: UUID,
    val title: String,
    val description: String,
    val durationMinutes: Int,
    val director: String,
    val genre: String,
    val releaseYear: Int,
    val imageProfile: String,
    val imageLandscape: String

)
