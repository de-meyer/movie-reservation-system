package com.cli.fancy.cinevault.domain.movie

import java.util.UUID

data class MovieBrowserInformation(
    val title: String,
    val imageProfile: String,
    val imageLandscape: String,
    val id: UUID
)
