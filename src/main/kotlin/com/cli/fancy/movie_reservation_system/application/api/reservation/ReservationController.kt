package com.cli.fancy.movie_reservation_system.application.api.reservation

import com.cli.fancy.movie_reservation_system.application.api.reservation.dto.ReservationRequest
import com.cli.fancy.movie_reservation_system.application.api.reservation.dto.ReservationResponse
import com.cli.fancy.movie_reservation_system.application.api.reservation.mapper.toDto
import com.cli.fancy.movie_reservation_system.domain.reservation.ReservationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/reservations")
class ReservationController(
    private val reservationService: ReservationService
) {

    @PostMapping
    fun createReservation(@RequestBody reservationRequest: ReservationRequest): Mono<ResponseEntity<ReservationResponse>> =
        reservationService.createReservation(reservationRequest)
            .map { ResponseEntity.ok(it.toDto()) }

    @GetMapping
    fun getReservations(): Flux<ReservationResponse> =
        reservationService.getAllReservations()
            .map { it.toDto() }
}