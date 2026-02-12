package com.cli.fancy.movie_reservation_system.application.api.program

import com.cli.fancy.movie_reservation_system.application.api.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.application.api.program.mapper.toProgramResponse
import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Instant
import java.time.temporal.ChronoUnit

@RestController
@RequestMapping("/program")
@Tag(name = "Program", description = "Public program information API - no authentication required")
class ProgramController(val service: ProgramService) {

    @GetMapping("/current")
    @Operation(summary = "Get current program", description = "Retrieve the currently running program")
    fun getCurrentProgram(): Flux<ProgramResponse> {
        val response = service.getProgramList(Instant.now()).map { it.toProgramResponse() }
        return response
    }

    @GetMapping("/today")
    @Operation(summary = "Get today's program", description = "Retrieve today's program schedule")
    fun getTodayProgram(): Flux<ProgramResponse> {
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS)
        val response =
            service.getDaySpecificProgramList(startOfDay).map { it.toProgramResponse() }
        return response
    }

    @GetMapping("/tomorrow")
    @Operation(summary = "Get tomorrow's program", description = "Retrieve tomorrow's program schedule")
    fun getTomorrowProgram(): Flux<ProgramResponse> {
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS).plus(1, ChronoUnit.DAYS)

        val response =
            service.getDaySpecificProgramList(startOfDay).map { it.toProgramResponse() }
        return response
    }
}
