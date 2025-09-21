package com.cli.fancy.movie_reservation_system.domain.theater

import com.cli.fancy.movie_reservation_system.application.theater.dto.TheaterResponse
import com.cli.fancy.movie_reservation_system.application.theater.mapper.TheaterMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TheaterService(
    val theaterRepository: TheaterRepository,
    val theaterMapper: TheaterMapper
) {
    fun getAllTheaters(): List<Theater> =
        theaterRepository.findAll().map { theaterMapper.toDomain(it) }.toList()

    fun getTheaterById(id: UUID): Theater? {
        val theaterEntity = theaterRepository.findById(id)
        return if (theaterEntity.isPresent) {
            theaterMapper.toDomain(theaterEntity.get())
        } else {
            null
        }
    }
}