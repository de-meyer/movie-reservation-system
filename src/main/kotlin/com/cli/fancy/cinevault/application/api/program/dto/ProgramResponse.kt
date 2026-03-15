package com.cli.fancy.cinevault.application.api.program.dto

import com.cli.fancy.cinevault.domain.movie.Movie
import com.cli.fancy.cinevault.domain.show.ShowSchedule

data class ProgramResponse(
    val movie: Movie,
    val shows: List<ShowSchedule>,
)
