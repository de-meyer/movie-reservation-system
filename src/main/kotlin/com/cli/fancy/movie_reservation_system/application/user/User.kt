package com.cli.fancy.movie_reservation_system.application.user

data class User(
    val id: Long? = null,
    val name: String,
    val email: String,
    val role: String,
)