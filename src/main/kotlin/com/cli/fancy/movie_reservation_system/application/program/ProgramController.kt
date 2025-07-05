package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/program")
class ProgramController(val programService: ProgramService) {
    @GetMapping("/current")
    fun getProgramForTheWeek(): List<ProgramDTO> {
        return programService.getProgramForTheWeek()
    }

    fun getProgramById(id: UUID): ProgramDTO? {
        return programService.findById(id)
    }

    fun getAllPrograms(): List<ProgramDTO> {
        return programService.findAll()
    }

}