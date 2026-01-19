package com.cli.fancy.movie_reservation_system.domain.user

import com.cli.fancy.movie_reservation_system.application.user.dto.UserLoginRequest
import com.cli.fancy.movie_reservation_system.application.user.mapper.toLoginRequestEntity
import com.cli.fancy.movie_reservation_system.application.user.mapper.toUserDomain
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.AuthRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
open class UserService(private val authRepository: AuthRepository) {
    fun getAllUsers(): Flux<User> = authRepository.findAll().map { it.toUserDomain() }
    fun getUserById(id: UUID): Mono<User> =
        authRepository.findById(id)
            .switchIfEmpty(Mono.error(NoSuchElementException("User with id $id not found")))
            .map { it.toUserDomain() }
    
    fun getUserByEmail(email: String): Mono<User> =
        authRepository.getUserByEmail(email = email)
            .switchIfEmpty(Mono.error(NoSuchElementException("User with id $email not found")))
            .map { it.toUserDomain() }

    @Transactional
    open fun registerUser(userLoginRequest: UserLoginRequest): Mono<User> =
        authRepository.existsByEmail(userLoginRequest.email)
            .flatMap { exists ->
                if (exists) {
                    Mono.error(IllegalArgumentException("Email is already in use"))
                } else {
                    val user = userLoginRequest.toLoginRequestEntity()
                    authRepository.save(user)
                }
            }
            .map { savedUser ->
                savedUser.toUserDomain()
            }
}