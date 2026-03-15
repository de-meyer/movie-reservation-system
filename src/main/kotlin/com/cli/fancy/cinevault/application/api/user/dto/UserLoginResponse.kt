package com.cli.fancy.cinevault.application.api.user.dto

import java.util.*

data class UserLoginResponse(
    val id: UUID?,
    val providerId: String,
    val name: String,
    val email: String,
    val avatar: String,
    val role: String,
)
