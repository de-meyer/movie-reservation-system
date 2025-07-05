package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.program.ProgramDTO
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramEntity
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramRepository
import org.springframework.stereotype.Service
import java.time.Instant
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

    /**
     * Retrieves the program.
     * Starting from the current date, it fetches all programs scheduled within the next 14 days.
     */
    fun getProgramForTheWeek(): List<ProgramDTO> {
        // Assuming we want to get programs for the current week
        val startOfWeek = Instant.now()
        // Calculate the end of the next 14 days (2 weeks))
        val endOfWeek = startOfWeek.plusSeconds(15 * 24 * 60 * 60)
        /// TODO: use builder to map to a Program Movie Model which should be returned instead of monvieId
        return programRepository.findAll()
            .filter { it.date in startOfWeek..endOfWeek }
            .map { it.toDTO() }
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

