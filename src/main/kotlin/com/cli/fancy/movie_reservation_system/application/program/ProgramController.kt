package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.application.program.mapper.ProgramMapper
import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/program")
class ProgramController(val programService: ProgramService, val programMapper: ProgramMapper) {
    @GetMapping("/current")
    fun getProgramForTheWeek(): List<ProgramResponse> {
        return programService.getProgramForTheWeek().map { programMapper.toDto(it) }
    }

    fun getProgramById(id: UUID): ProgramResponse? {
        return programService.findById(id)?.let { programMapper.toDto(it) }
    }

    fun getAllPrograms(): List<ProgramResponse> {
        return programService.findAll().map { programMapper.toDto(it) }
    }

}