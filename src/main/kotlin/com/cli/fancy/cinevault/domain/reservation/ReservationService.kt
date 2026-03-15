package com.cli.fancy.cinevault.domain.reservation

import com.cli.fancy.cinevault.application.api.reservation.dto.ReservationRequest
import com.cli.fancy.cinevault.application.api.reservation.mapper.toDomain
import com.cli.fancy.cinevault.application.api.reservation.mapper.toEntity
import com.cli.fancy.cinevault.infrastructure.persistence.reservation.ReservationRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ReservationService(
    val reservationRepository: ReservationRepository
) {
    fun createReservation(request: ReservationRequest): Mono<Reservation> =
        reservationRepository.save(request.toEntity())
            .map { it.toDomain() }

    fun getAllReservations(): Flux<Reservation> =
        reservationRepository.findAll().map { it.toDomain() }
}
