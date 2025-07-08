package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.program.mapper.ProgramMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class ProgramService(val programRepository: ProgramRepository, val programMapper: ProgramMapper) {

    fun findAll(): List<Program> {
        return programRepository.findAll().map { programMapper.toProgram(it) }
            .toList()
    }

    fun findById(id: UUID): Program? {
        val programEntity = programRepository.findById(id)
            .orElseThrow { NoSuchElementException("Program with id $id not found") }

        return programMapper.toProgram(programEntity)

    }

    /**
     * Retrieves the program.
     * Starting from the current date, it fetches all programs scheduled within the next 14 days.
     */
    fun getProgramForTheWeek(): List<Program> {
        // Assuming we want to get programs for the current week
        val startOfWeek = Instant.now()
        // Calculate the end of the next 14 days (2 weeks))
        val endOfWeek = startOfWeek.plusSeconds(15 * 24 * 60 * 60)
        return programRepository.findAll()
            .filter { it.id.date in startOfWeek..endOfWeek }
            .map { programMapper.toProgram(it) }
    }

    fun deleteById(id: UUID) {
        programRepository.deleteById(id)
    }
}

