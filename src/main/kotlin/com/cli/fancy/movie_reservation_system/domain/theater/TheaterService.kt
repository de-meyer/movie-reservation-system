package com.cli.fancy.movie_reservation_system.domain.theater

import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toSeat
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toTheater
import com.cli.fancy.movie_reservation_system.domain.seat.Seat
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.seat.SeatRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class TheaterService(
    val theaterRepository: TheaterRepository,
    val seatRepository: SeatRepository
) {
    fun getTheaterSeats(id: UUID): Flux<Seat> = seatRepository.findByTheaterId(id)
        .switchIfEmpty(Flux.error(NoSuchElementException("Seats for theater id $id not found")))
        .map { it.toSeat() }

    fun getAllTheaters(): Flux<Theater> =
        theaterRepository.findAll().map { it.toTheater() }
}
