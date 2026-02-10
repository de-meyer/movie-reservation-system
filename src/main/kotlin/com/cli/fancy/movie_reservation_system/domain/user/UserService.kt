package com.cli.fancy.movie_reservation_system.domain.user

import com.cli.fancy.movie_reservation_system.application.api.user.mapper.toUserDomain
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.UserEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): Flux<User> = userRepository.findAll().map { it.toUserDomain() }
    fun getUserById(id: String): Mono<User> =
        userRepository.findById(id)
            .switchIfEmpty(Mono.error(NoSuchElementException("User with id $id not found")))
            .map { it.toUserDomain() }

    fun findOrCreateDiscordUser(
        id: String,
        name: String,
        email: String,
        avatar: String
    ): Mono<UserEntity> {
        return userRepository.findById(id)
            .switchIfEmpty(
                userRepository.save(
                    UserEntity(
                        id = id,
                        email = email,
                        name = name,
                        avatar = avatar
                    )
                )
            )
            .flatMap { existingUser ->
                // Update username/avatar if changed
                if (existingUser.name != name || existingUser.avatar != avatar || existingUser.email != email) {
                    userRepository.save(
                        existingUser.copy(
                            name = name,
                            email = email,
                            avatar = avatar
                        )
                    )
                } else {
                    Mono.just(existingUser)
                }
            }
    }
}
