package com.cli.fancy.movie_reservation_system.api.auth

import com.cli.fancy.movie_reservation_system.api.user.UserEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface AuthRepository : CrudRepository<UserEntity, Long> {
    fun getUserEntityByName(name: String): UserEntity
    fun getUserByEmail(email: String): Optional<UserEntity>
    fun existsByEmail(email: String): Boolean
}