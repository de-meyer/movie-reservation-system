package com.cli.fancy.cinevault.infrastructure.persistence.user

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.UUID

@Repository
interface UserRepository : ReactiveCrudRepository<UserEntity, UUID> {
    fun findByProviderIdAndProvider(providerId: String, provider: String): Mono<UserEntity>
}
