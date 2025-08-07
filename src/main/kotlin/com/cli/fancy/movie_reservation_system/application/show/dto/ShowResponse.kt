package com.cli.fancy.movie_reservation_system.application.show.dto

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowId
import java.time.Instant
import java.util.*

data class ShowResponse(
    val id: ShowId,
) {
    /// TODO: Do I really need to expose these properties? For the sake of not access those properties via `id`
    val movieId: UUID
        get() = id.movieId

    val date: Instant
        get() = id.date

    val theaterId: UUID
        get() = id.theaterId

    fun toEntity(): ShowEntity {
        return ShowEntity(
            id = this.id,
        )
    }
}