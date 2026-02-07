package com.cli.fancy.movie_reservation_system.domain.reservation

import com.cli.fancy.movie_reservation_system.application.api.reservation.dto.ReservationRequest
import com.cli.fancy.movie_reservation_system.application.api.reservation.mapper.toDomain
import com.cli.fancy.movie_reservation_system.application.api.reservation.mapper.toEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation.ReservationRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class ReservationService(
    val reservationRepository: ReservationRepository
) {
    fun createReservation(request: ReservationRequest): Mono<Reservation> =
        reservationRepository.save(request.toEntity())
            .map { it.toDomain() }


    fun getAllReservations(): Flux<Reservation> =
        reservationRepository.findAll().map { it.toDomain() }

    fun getReservationById(id: UUID): Mono<Reservation> =
        reservationRepository.findById(id)
            .switchIfEmpty(Mono.error(NoSuchElementException("Reservation with $id not found!")))
            .map { it.toDomain() }
}