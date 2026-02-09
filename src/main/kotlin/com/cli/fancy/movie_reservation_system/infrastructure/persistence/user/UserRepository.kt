package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveCrudRepository<UserEntity, String>
