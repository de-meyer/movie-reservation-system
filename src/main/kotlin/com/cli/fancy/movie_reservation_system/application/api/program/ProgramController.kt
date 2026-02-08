package com.cli.fancy.movie_reservation_system.application.api.program

import com.cli.fancy.movie_reservation_system.application.api.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.application.api.program.mapper.toProgramResponse
import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Instant
import java.time.temporal.ChronoUnit

@RestController
@RequestMapping("/program")
class ProgramController(val service: ProgramService) {

    @GetMapping("/current")
    fun getCurrentProgram(
    ): Flux<ProgramResponse> {
        val response = service.getProgramList(Instant.now()).map { it.toProgramResponse() }
        return response
    }

    @GetMapping("/today")
    fun getTodayProgram(
    ): Flux<ProgramResponse> {
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS)
        val response =
            service.getDaySpecificProgramList(startOfDay).map { it.toProgramResponse() }
        return response
    }

    @GetMapping("/tomorrow")
    fun getTomorrowsProgram(
    ): Flux<ProgramResponse> {
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS).plus(1, ChronoUnit.DAYS)

        val response =
            service.getDaySpecificProgramList(startOfDay).map { it.toProgramResponse() }
        return response
    }

}