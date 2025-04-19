package com.cli.fancy.movie_reservation_system.api.user

data class PrincipalUser(
    val id: Long? = null,
    val name: String,
    val email: String,
    val role: String,
)