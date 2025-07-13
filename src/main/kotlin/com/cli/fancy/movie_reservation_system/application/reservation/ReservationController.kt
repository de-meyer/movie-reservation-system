package com.cli.fancy.movie_reservation_system.application.reservation

import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationRequest
import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationResponse
import com.cli.fancy.movie_reservation_system.application.reservation.mapper.ReservationMapper
import com.cli.fancy.movie_reservation_system.domain.reservation.ReservationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reservations")
class ReservationController(
    private val reservationService: ReservationService, val reservationMapper: ReservationMapper
) {

    // Define endpoints for reservation operations here

    @PostMapping
    fun createReservation(@RequestBody reservationRequest: ReservationRequest): ResponseEntity<ReservationResponse> {
        val reservation = reservationService.createReservation(reservationRequest)
        return ResponseEntity.ok(reservationMapper.toDto(reservation))
    }

    @GetMapping
    fun getReservations(): ResponseEntity<List<ReservationResponse>> {
        val reservations = reservationService.getAllReservations()
        return ResponseEntity.ok(reservations.map { reservationMapper.toDto(it) })
    }

    // Other endpoints can be added similarly) {
}