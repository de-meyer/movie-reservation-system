package com.cli.fancy.cinevault.application.api.user.dto

import java.util.UUID

data class UserResponse(
    val id: UUID?,
    val name: String,
    val email: String,
    val role: String,
)
