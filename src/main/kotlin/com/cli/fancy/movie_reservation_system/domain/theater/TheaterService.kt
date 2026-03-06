package com.cli.fancy.movie_reservation_system.domain.theater

import com.cli.fancy.movie_reservation_system.application.api.theater.dto.SeatResponse
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toSeatResponse
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toTheater
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.seat.SeatRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.UUID

@Service
class TheaterService(
    val theaterRepository: TheaterRepository,
    val seatRepository: SeatRepository
) {
    fun getTheaterSeats(id: UUID): Flux<SeatResponse> = seatRepository.findByTheaterId(id)
        .switchIfEmpty(Flux.error(NoSuchElementException("Seats for theater id $id not found")))
        .map { it.toSeatResponse() }

    fun getAllTheaters(): Flux<Theater> =
        theaterRepository.findAll().map { it.toTheater() }
}
