package com.cli.fancy.movie_reservation_system.application.program.mapper

import com.cli.fancy.movie_reservation_system.application.program.dto.ProgramResponse
import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.program.Program
import com.cli.fancy.movie_reservation_system.domain.show.Show
import com.cli.fancy.movie_reservation_system.domain.theater.Theater
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun Program.toProgram(): Program = Program(
    movie = this.movie,
    shows = this.shows,
)

fun Program.toProgramResponse(): ProgramResponse = ProgramResponse(
    movie = this.movie,
    shows = this.shows
)