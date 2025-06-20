package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.domain.program.ProgramService
import java.util.UUID

class ProgramController(val programService: ProgramService) {


    fun getProgramById(id: UUID): ProgramDTO? {
        return programService.findById(id)
    }

    fun getAllPrograms(): List<ProgramDTO> {
        return programService.findAll()
    }

}