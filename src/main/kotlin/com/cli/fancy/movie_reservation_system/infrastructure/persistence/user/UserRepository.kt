package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

interface AuthRepository : JpaRepository<UserEntity, Long> {
    fun getUserEntityByName(name: String): UserEntity
    fun getUserByEmail(email: String): Optional<UserEntity>
    fun existsByEmail(email: String): Boolean
    fun findById(id: UUID): Optional<UserEntity>
}