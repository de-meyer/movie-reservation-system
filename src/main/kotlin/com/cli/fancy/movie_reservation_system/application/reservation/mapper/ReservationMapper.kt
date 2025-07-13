package com.cli.fancy.movie_reservation_system.application.reservation.mapper

import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationRequest
import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationResponse
import com.cli.fancy.movie_reservation_system.domain.reservation.Reservation
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation.ReservationEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ReservationMapper {
    // Define mapping methods here
    fun toDto(reservation: Reservation): ReservationResponse
    fun toEntity(reservationRequest: ReservationRequest): ReservationEntity
    fun toDomain(reservationEntity: ReservationEntity): Reservation
}