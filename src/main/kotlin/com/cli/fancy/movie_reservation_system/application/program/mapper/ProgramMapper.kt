package com.cli.fancy.movie_reservation_system.application.program.mapper

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.domain.program.Program
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ProgramMapper {
    fun toDto(program: Program): ProgramResponse
    fun toEntity(programResponse: ProgramResponse): ProgramEntity
    fun toProgram(programEntity: ProgramEntity): Program
}