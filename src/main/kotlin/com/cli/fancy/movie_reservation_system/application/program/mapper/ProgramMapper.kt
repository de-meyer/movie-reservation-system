package com.cli.fancy.movie_reservation_system.application.program.mapper

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.domain.program.Program

fun Program.toProgram(): Program = Program(
    movie = this.movie,
    shows = this.shows,
)

fun Program.toProgramResponse(): ProgramResponse = ProgramResponse(
    movie = this.movie,
    shows = this.shows
)