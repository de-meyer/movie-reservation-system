package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono
import java.util.*

interface AuthRepository : R2dbcRepository<UserEntity, Long> {
    fun getUserEntityByName(name: String): Mono<UserEntity>
    fun getUserByEmail(email: String): Mono<UserEntity>
    fun existsByEmail(email: String): Mono<Boolean>
    fun findById(id: UUID): Mono<UserEntity>
}