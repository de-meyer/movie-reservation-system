package com.cli.fancy.movie_reservation_system.application.program.dto

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramId
import java.time.Instant
import java.util.*

data class ProgramResponse(
    val id: ProgramId,
) {
    /// TODO: Do I really need to expose these properties? For the sake of not access those properties via `id`
    val movieId: UUID
        get() = id.movieId

    val date: Instant
        get() = id.date

    val theaterId: UUID
        get() = id.theaterId

    fun toEntity(): ProgramEntity {
        return ProgramEntity(
            id = this.id,
        )
    }
}