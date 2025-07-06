package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramDto
import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/program")
class ProgramController(val programService: ProgramService) {
    @GetMapping("/current")
    fun getProgramForTheWeek(): List<ProgramDto> {
        return programService.getProgramForTheWeek()
    }

    fun getProgramById(id: UUID): ProgramDto? {
        return programService.findById(id)
    }

    fun getAllPrograms(): List<ProgramDto> {
        return programService.findAll()
    }

}