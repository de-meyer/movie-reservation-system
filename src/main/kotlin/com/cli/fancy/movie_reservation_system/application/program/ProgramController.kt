package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.application.program.mapper.ProgramMapper
import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/program")
class ProgramController(val service: ProgramService, val programMapper: ProgramMapper) {

    @GetMapping("/current")
    fun getCurrentProgram(): ResponseEntity<List<ProgramResponse>> {
        // Implementation to retrieve current program with shows and movies
        val response = service.getPrograms().map { programMapper.toProgramResponse(it) }

        return ResponseEntity.ok(response)
    }
}