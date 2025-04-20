package com.cli.fancy.movie_reservation_system.domain.movie

data class Movie(
    val id: Long? = null,
    val title: String,
    val description: String,
    val duration: Int,
    val genre: String,
    val releaseDate: String,
    val rating: Double,
)
