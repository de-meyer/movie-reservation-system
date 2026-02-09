package com.cli.fancy.movie_reservation_system.application.api.user.dto

data class UserResponse(
    val id: String,
    val name: String,
    val email: String,
    val role: String,
)