package com.cli.fancy.movie_reservation_system.application.theater

import com.cli.fancy.movie_reservation_system.application.theater.dto.TheaterResponse
import com.cli.fancy.movie_reservation_system.application.theater.mapper.toDto
import com.cli.fancy.movie_reservation_system.domain.theater.TheaterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/theater")
class TheaterController(private val theaterService: TheaterService) {
    @GetMapping("/list")
    fun listTheaters(): List<TheaterResponse> {
        return theaterService.getAllTheaters()
            .map { it.toDto() }
    }
}