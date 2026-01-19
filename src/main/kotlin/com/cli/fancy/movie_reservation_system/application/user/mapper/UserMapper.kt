package com.cli.fancy.movie_reservation_system.application.user.mapper

import com.cli.fancy.movie_reservation_system.application.user.dto.UserLoginRequest
import com.cli.fancy.movie_reservation_system.application.user.dto.UserResponse
import com.cli.fancy.movie_reservation_system.domain.user.User
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.UserEntity

fun User.toDto(): UserResponse = UserResponse(
    id = requireNotNull(this.id) { "User must be persisted before converting to DTO" },
    name = this.name,
    email = this.email,
    role = this.role,
)

fun UserLoginRequest.toLoginRequestEntity(): UserEntity = UserEntity(
    name = this.name,
    email = this.email,
)

fun UserEntity.toUserDomain(): User = User(
    id = this.id,
    name = this.name,
    email = this.email,
    role = this.role,
)
