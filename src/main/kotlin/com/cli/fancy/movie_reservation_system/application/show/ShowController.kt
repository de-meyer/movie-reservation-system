package com.cli.fancy.movie_reservation_system.application.show

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.application.show.mapper.ShowMapper
import com.cli.fancy.movie_reservation_system.domain.show.ShowService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/shows")
class ShowController(val showService: ShowService, val showMapper: ShowMapper) {
    @GetMapping("/current")
    fun getProgramForTheWeek(): List<ShowResponse> {
        return showService.getProgramForTheWeek().map { showMapper.toDto(it) }
    }

    fun getProgramById(id: UUID): ShowResponse? {
        return showService.findById(id)?.let { showMapper.toDto(it) }
    }

    @GetMapping("/all")
    fun getAllPrograms(): List<ShowResponse> {
        return showService.findAll().map { showMapper.toDto(it) }
    }

}