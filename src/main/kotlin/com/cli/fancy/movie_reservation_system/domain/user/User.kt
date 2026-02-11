package com.cli.fancy.movie_reservation_system.domain.user

import java.util.UUID

data class User(
    val id: UUID?,
    val providerId: String,
    val provider: String,
    val name: String,
    val avatar: String,
    val role: String,
    val email: String
)
