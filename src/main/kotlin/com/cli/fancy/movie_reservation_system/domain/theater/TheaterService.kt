package com.cli.fancy.movie_reservation_system.domain.theater

import com.cli.fancy.movie_reservation_system.application.api.theater.dto.SeatResponse
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toTheater
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.UUID

@Service
class TheaterService(
    val theaterRepository: TheaterRepository,
) {
    fun getAllTheaters(): Flux<Theater> =
        theaterRepository.findAll().map { it.toTheater() }

    fun getTheaterSeats(val id: UUID): Flux<SeatResponse> = theaterRepository.findById(id)
        .switchIfEmpty(Flux.error(NoSuchElementException("Theater with id $id not found")))
        .flatMapMany { Flux.fromIterable(it.seats) }
}
