package com.cli.fancy.movie_reservation_system.domain.theater

import com.cli.fancy.movie_reservation_system.application.theater.mapper.toTheater
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class TheaterService(
    val theaterRepository: TheaterRepository,
) {
    fun getAllTheaters(): Flux<Theater> =
        theaterRepository.findAll().map { it.toTheater() }

    fun getTheaterById(id: UUID): Mono<Theater> =
        theaterRepository.findById(id)
            .switchIfEmpty(Mono.error(NoSuchElementException("There is no theater with id $id")))
            .map { it.toTheater() }

}