package com.cli.fancy.movie_reservation_system.application.show.mapper

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowCreateRequest
import com.cli.fancy.movie_reservation_system.application.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.domain.show.Show
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowsEntity

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
    date = this.date.toString() // FIXME: this should be Instant
)

fun ShowCreateRequest.toEntity(): ShowsEntity = ShowsEntity(
    movieId = this.movieId,
    theaterId = this.theaterId,
    date = this.date,
)