package com.cli.fancy.movie_reservation_system.application.program

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramEntity
import java.time.Instant
import java.util.UUID

data class ProgramDTO(
    val id: UUID,
    val movieId: UUID,
    val date: Instant,
) {
    fun toEntity(): ProgramEntity {
        return ProgramEntity(
            id = this.id,
            movieId = this.movieId,
            date = this.date,
        )
    }
}