package com.cli.fancy.movie_reservation_system.application.reservation

import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationRequest
import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationResponse
import com.cli.fancy.movie_reservation_system.application.reservation.mapper.toDto
import com.cli.fancy.movie_reservation_system.domain.reservation.ReservationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reservations")
class ReservationController(
    private val reservationService: ReservationService
) {

    // Define endpoints for reservation operations here

    @PostMapping
    fun createReservation(@RequestBody reservationRequest: ReservationRequest): ResponseEntity<ReservationResponse> {
        val reservation = reservationService.createReservation(reservationRequest)
        return ResponseEntity.ok(reservation.toDto())
    }

    @GetMapping
    fun getReservations(): ResponseEntity<List<ReservationResponse>> {
        val reservations = reservationService.getAllReservations()
        return ResponseEntity.ok(reservations.map { it.toDto() })
    }
}