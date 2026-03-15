package com.cli.fancy.cinevault.application.api.show.mapper

import com.cli.fancy.cinevault.application.api.show.dto.ShowCreateRequest
import com.cli.fancy.cinevault.application.api.show.dto.ShowResponse
import com.cli.fancy.cinevault.domain.show.Show
import com.cli.fancy.cinevault.infrastructure.persistence.show.ShowsEntity

fun ShowsEntity.toShow(): Show = Show(
    id = this.id,
    theaterId = this.theaterId,
    movieId = this.movieId,
    date = this.date,
)

fun Show.toShowResponse(): ShowResponse = ShowResponse(
    id = this.id,
    theaterId = this.theaterId,
    movieId = this.movieId,
    date = this.date.toString()
)

fun ShowCreateRequest.toEntity(): ShowsEntity = ShowsEntity(
    movieId = this.movieId,
    theaterId = this.theaterId,
    date = this.date,
)
