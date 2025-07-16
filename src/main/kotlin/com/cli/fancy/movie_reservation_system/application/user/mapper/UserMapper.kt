package com.cli.fancy.movie_reservation_system.application.user.mapper

import com.cli.fancy.movie_reservation_system.application.user.dto.UserResponse
import com.cli.fancy.movie_reservation_system.application.user.dto.UserLoginRequest
import com.cli.fancy.movie_reservation_system.domain.user.User
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.UserEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toDto(user: User): UserResponse
    fun toEntity(user: UserResponse): UserEntity
    fun toLoginRequestEntity(userLoginRequest: UserLoginRequest): UserEntity
    fun toUserDomain(userEntity: UserEntity): User
}