package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import org.springframework.data.repository.CrudRepository
import java.util.*

interface MovieRepository: CrudRepository<MovieEntity, UUID> {

}