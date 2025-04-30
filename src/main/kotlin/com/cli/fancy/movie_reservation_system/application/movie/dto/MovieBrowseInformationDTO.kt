package com.cli.fancy.movie_reservation_system.application.movie.dto

data class MovieBrowseInformationDTO (
    val name: String,
    val image: String = "",
    val url: String
)