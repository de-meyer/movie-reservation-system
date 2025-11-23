package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.application.program.mapper.ProgramMapper
import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.time.Duration
import kotlin.time.DurationUnit

@RestController
@RequestMapping("/program")
class ProgramController(val service: ProgramService, val programMapper: ProgramMapper) {

    @GetMapping("/current")
    fun getCurrentProgram(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "30") size: Int
    ): ResponseEntity<Page<ProgramResponse>> {
        val response = service.getProgramList(page, size, Instant.now()).map { programMapper.toProgramResponse(it) }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/today")
    fun getTodayProgram(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "30") size: Int
    ): ResponseEntity<Page<ProgramResponse>> {
        // Implementation to retrieve todays program with shows and movies
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS)
        val response =
            service.getDaySpecificProgramList(startOfDay, page, size).map { programMapper.toProgramResponse(it) }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/tomorrow")
    fun getTomorrowsProgram(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "30") size: Int
    ): ResponseEntity<Page<ProgramResponse>> {
        // Implementation to retrieve todays program with shows and movies
        val startOfDay = Instant.now().truncatedTo(ChronoUnit.DAYS).plus(1, ChronoUnit.DAYS)

        val response =
            service.getDaySpecificProgramList(startOfDay, page, size).map { programMapper.toProgramResponse(it) }
        return ResponseEntity.ok(response)
    }

}