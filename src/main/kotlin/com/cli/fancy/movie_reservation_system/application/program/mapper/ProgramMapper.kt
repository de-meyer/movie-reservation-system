package com.cli.fancy.movie_reservation_system.application.program.mapper

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.program.Program
import com.cli.fancy.movie_reservation_system.domain.show.Show
import com.cli.fancy.movie_reservation_system.domain.theater.Theater
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ProgramMapper {
    fun toProgram(shows: List<Show>, movie: Movie, theaters: List<Theater>): Program
    fun toProgramResponse(program: Program): ProgramResponse
}