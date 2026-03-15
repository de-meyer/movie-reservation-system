package com.cli.fancy.cinevault.domain.program

import com.cli.fancy.cinevault.domain.movie.Movie
import com.cli.fancy.cinevault.domain.show.ShowSchedule

data class Program(
    val movie: Movie,
    val shows: List<ShowSchedule>
)
