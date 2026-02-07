package com.cli.fancy.movie_reservation_system.application.api.user.dto

import java.util.*

data class UserResponse(
    val id: UUID,
    val name: String,
    val email: String,
    val role: String,
)