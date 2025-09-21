package com.cli.fancy.movie_reservation_system.application.theater.mapper

import com.cli.fancy.movie_reservation_system.application.theater.dto.TheaterRequest
import com.cli.fancy.movie_reservation_system.application.theater.dto.TheaterResponse
import com.cli.fancy.movie_reservation_system.domain.theater.Theater
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TheaterMapper {
    // Define mapping methods here
    fun toDto(theater: Theater): TheaterResponse
    fun toEntity(theaterRequest: TheaterRequest): TheaterEntity
    fun toDomain(theaterEntity: TheaterEntity): Theater
}