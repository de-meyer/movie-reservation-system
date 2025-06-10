package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.program.ProgramDTO
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProgramService(val programRepository: ProgramRepository) {

    fun findAll(): List<ProgramDTO> {
        return programRepository.findAll().map { it.toDTO() }
            .toList()
    }

    fun findById(id: UUID): ProgramDTO? {
        return programRepository.findById(id)
            .orElse(null)?.toDTO()
    }

    fun deleteById(id: UUID) {
        programRepository.deleteById(id)
    }
    private fun ProgramEntity.toDTO(): ProgramDTO {
        return ProgramDTO(
            id = this.id,
            movieId = this.movieId,
            date = this.date,
        )
    }
}

