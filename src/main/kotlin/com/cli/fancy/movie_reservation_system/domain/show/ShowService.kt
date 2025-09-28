package com.cli.fancy.movie_reservation_system.domain.show

import com.cli.fancy.movie_reservation_system.application.show.mapper.ShowMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class ShowService(val showRepository: ShowRepository, val showMapper: ShowMapper) {

    fun findAll(): List<Show> {
        return showRepository.findAll().map { showMapper.toShow(it) }
            .toList()
    }

    fun createShow(show: Show): Show {
        val showEntity = showMapper.toShowEntity(show)
        return showMapper.toShow(showRepository.save(showEntity))

    }

    fun findById(id: UUID): Show? {
        val showEntity = showRepository.findById(id)
            .orElseThrow { NoSuchElementException("Show with id $id not found") }

        return showMapper.toShow(showEntity)

    }

    /**
     * Retrieves the program.
     * Starting from the current date, it fetches all programs scheduled within the next 14 days.
     */
    fun getProgramForTheWeek(): List<Show> {
        // Assuming we want to get programs for the current week
        val startOfWeek = Instant.now()
        // Calculate the end of the next 14 days (2 weeks))
        val endOfWeek = startOfWeek.plusSeconds(15 * 24 * 60 * 60)
        return showRepository.findAll()
            .filter { it.date in startOfWeek..endOfWeek }
            .map { showMapper.toShow(it) }
    }

    fun deleteById(id: UUID) {
        showRepository.deleteById(id)
    }
}

