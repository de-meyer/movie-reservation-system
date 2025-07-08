package com.cli.fancy.movie_reservation_system.application.program.mapper

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramDto
import com.cli.fancy.movie_reservation_system.domain.program.Program
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ProgramMapper {
    fun toDto(program: Program): ProgramDto
    fun toEntity(programDto: ProgramDto): ProgramEntity
    fun toProgram(programEntity: ProgramEntity): Program
}