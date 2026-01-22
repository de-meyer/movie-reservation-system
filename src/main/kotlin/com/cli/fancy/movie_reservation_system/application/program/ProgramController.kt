package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.application.program.mapper.toProgramResponse
import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import org.springframework.http.ResponseEntity
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
    ): ResponseEntity<Flux<ProgramResponse>> {
        val response = service.getProgramList(Instant.now()).map { it.toProgramResponse() }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/today")
    fun getTodayProgram(
    ): ResponseEntity<Flux<ProgramResponse>> {
        // Implementation to retrieve todays program with shows and movies
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS)
        val response =
            service.getDaySpecificProgramList(startOfDay).map { it.toProgramResponse() }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/tomorrow")
    fun getTomorrowsProgram(
    ): ResponseEntity<Flux<ProgramResponse>> {
        // Implementation to retrieve todays program with shows and movies
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS).plus(1, ChronoUnit.DAYS)

        val response =
            service.getDaySpecificProgramList(startOfDay).map { it.toProgramResponse() }
        return ResponseEntity.ok(response)
    }

}