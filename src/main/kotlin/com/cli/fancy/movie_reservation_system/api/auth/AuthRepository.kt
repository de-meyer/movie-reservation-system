package com.cli.fancy.movie_reservation_system.api.auth

import com.cli.fancy.movie_reservation_system.api.user.UserEntity
import org.springframework.data.repository.CrudRepository


interface AuthRepository : CrudRepository<UserEntity, Long> {
    fun getUserEntityByName(name: String): UserEntity
    fun existsByEmail(email: String): Boolean
}