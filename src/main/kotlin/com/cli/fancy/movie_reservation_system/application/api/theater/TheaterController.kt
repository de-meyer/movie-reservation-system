package com.cli.fancy.movie_reservation_system.application.api.theater

import com.cli.fancy.movie_reservation_system.application.api.theater.dto.TheaterResponse
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toDto
import com.cli.fancy.movie_reservation_system.domain.theater.TheaterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/theater")
class TheaterController(private val theaterService: TheaterService) {
    @GetMapping("/list")
    fun listTheaters(): Flux<TheaterResponse> {
        return theaterService.getAllTheaters()
            .map { it.toDto() }
    }
}