package com.cli.fancy.movie_reservation_system.application.theater

import com.cli.fancy.movie_reservation_system.application.reservation.mapper.ReservationMapper
import com.cli.fancy.movie_reservation_system.application.theater.dto.TheaterResponse
import com.cli.fancy.movie_reservation_system.application.theater.mapper.TheaterMapper
import com.cli.fancy.movie_reservation_system.domain.reservation.ReservationService
import com.cli.fancy.movie_reservation_system.domain.theater.TheaterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/theater")
class TheaterController(private val theaterService: TheaterService, val theaterMapper: TheaterMapper) {
    @GetMapping("/list")
    fun listTheaters(): List<TheaterResponse> {
        return theaterService.getAllTheaters()
            .map { theaterMapper.toDto(it) }
    }
}