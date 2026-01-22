package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.*

interface AuthRepository : ReactiveCrudRepository<UserEntity, Long> {
    fun getUserByEmail(email: String): Mono<UserEntity>
    fun existsByEmail(email: String): Mono<Boolean>
    fun findById(id: UUID): Mono<UserEntity>
}