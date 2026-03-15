package com.cli.fancy.cinevault.application.api.user.mapper

import com.cli.fancy.cinevault.application.api.user.dto.UserLoginResponse
import com.cli.fancy.cinevault.application.api.user.dto.UserResponse
import com.cli.fancy.cinevault.domain.user.User
import com.cli.fancy.cinevault.infrastructure.persistence.user.UserEntity

fun User.toDto(): UserResponse = UserResponse(
    id = this.id,
    name = this.name,
    email = this.email,
    role = this.role,
)

fun User.toLoginDto(): UserLoginResponse = UserLoginResponse(
    id = this.id,
    providerId = this.providerId,
    name = this.name,
    email = this.email,
    avatar = this.avatar,
    role = this.role,
)

fun UserEntity.toUserDomain(): User = User(
    id = this.id,
    providerId = this.providerId,
    provider = this.provider,
    name = this.name,
    email = this.email,
    avatar = this.avatar,
    role = this.role,
)
