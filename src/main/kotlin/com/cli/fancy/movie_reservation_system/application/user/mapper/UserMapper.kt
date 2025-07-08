package com.cli.fancy.movie_reservation_system.application.user.mapper

import com.cli.fancy.movie_reservation_system.application.user.dto.UserDto
import com.cli.fancy.movie_reservation_system.application.user.dto.UserLoginRequestDto
import com.cli.fancy.movie_reservation_system.domain.user.User
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.UserEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toDto(user: User): UserDto
    fun toEntity(user: UserDto): UserEntity
    fun toLoginRequestEntity(userLoginRequest: UserLoginRequestDto): UserEntity
    fun toUserDomain(userEntity: UserEntity): User
}