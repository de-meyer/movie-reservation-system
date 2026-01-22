package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface MovieRepository : ReactiveCrudRepository<MovieEntity, UUID> {

}