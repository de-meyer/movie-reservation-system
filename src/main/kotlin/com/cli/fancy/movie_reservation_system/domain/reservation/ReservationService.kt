package com.cli.fancy.movie_reservation_system.domain.reservation

import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationRequest
import com.cli.fancy.movie_reservation_system.application.reservation.mapper.ReservationMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation.ReservationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReservationService(
    val reservationRepository: ReservationRepository,
    val reservationMapper: ReservationMapper
) {
    fun createReservation(request: ReservationRequest): Reservation {
        val reservationEntity = reservationMapper.toEntity(request)
        val savedEntity = reservationRepository.save(reservationEntity)
        return reservationMapper.toDomain(savedEntity)
    }

    fun getAllReservations(): List<Reservation> =
        reservationRepository.findAll().map { reservationMapper.toDomain(it) }.toList()

    fun getReservationById(id: UUID): Reservation? {
        val reservationEntity = reservationRepository.findById(id)
        return if (reservationEntity.isPresent) {
            reservationMapper.toDomain(reservationEntity.get())
        } else {
            null
        }
    }
}