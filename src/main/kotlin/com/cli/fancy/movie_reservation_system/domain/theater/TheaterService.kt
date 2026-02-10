package com.cli.fancy.movie_reservation_system.domain.theater

import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toTheater
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class TheaterService(
    val theaterRepository: TheaterRepository,
) {
    fun getAllTheaters(): Flux<Theater> =
        theaterRepository.findAll().map { it.toTheater() }

}
