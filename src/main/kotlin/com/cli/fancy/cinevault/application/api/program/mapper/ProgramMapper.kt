package com.cli.fancy.cinevault.application.api.program.mapper

import com.cli.fancy.cinevault.application.api.program.dto.ProgramResponse
import com.cli.fancy.cinevault.domain.program.Program

fun Program.toProgramResponse(): ProgramResponse = ProgramResponse(
    movie = this.movie,
    shows = this.shows
)
