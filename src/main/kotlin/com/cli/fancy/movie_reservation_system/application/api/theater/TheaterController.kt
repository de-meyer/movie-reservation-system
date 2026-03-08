package com.cli.fancy.movie_reservation_system.application.api.theater

import com.cli.fancy.movie_reservation_system.application.api.theater.dto.SeatResponse
import com.cli.fancy.movie_reservation_system.application.api.theater.dto.TheaterResponse
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toDto
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toSeatResponse
import com.cli.fancy.movie_reservation_system.domain.theater.TheaterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.util.UUID

@RestController
@RequestMapping("/theater")
class TheaterController(private val theaterService: TheaterService) {
    @GetMapping("/list")
    fun listTheaters(): Flux<TheaterResponse> {
        return theaterService.getAllTheaters()
            .map { it.toDto() }
    }

    @GetMapping("/{id}/seats")
    fun getTheaterSeats(@PathVariable id: String): Flux<SeatResponse> =
        theaterService.getTheaterSeats(UUID.fromString(id))
            .map { it.toSeatResponse() }
}
