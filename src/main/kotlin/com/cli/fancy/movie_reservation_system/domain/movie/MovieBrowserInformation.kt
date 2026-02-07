package com.cli.fancy.movie_reservation_system.domain.movie

import java.util.UUID

data class MovieBrowserInformation(
    val title: String,
    val imageProfile: String,
    val imageLandscape: String,
    val id: UUID
)
