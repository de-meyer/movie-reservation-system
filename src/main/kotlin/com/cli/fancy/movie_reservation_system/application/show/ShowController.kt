package com.cli.fancy.movie_reservation_system.application.show

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowCreateRequest
import com.cli.fancy.movie_reservation_system.application.show.mapper.ShowMapper
import com.cli.fancy.movie_reservation_system.domain.show.ShowService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/show")
class ShowController(val showService: ShowService, val showMapper: ShowMapper) {
    /*@GetMapping("/current")
    fun getProgramForTheWeek(): List<ShowResponse> {
        return showService.getProgramForTheWeek().map { showMapper.toDto(it) }
    }*/

    @PostMapping("/create")
    fun createShow(@RequestBody request: ShowCreateRequest): ResponseEntity<String> {
        try {
            val showEntity = showMapper.toEntityFromCreateRequest(request)
            showService.createShow(showEntity = showEntity)
            return ResponseEntity.ok().body("Success")
        } catch (ex: Exception) {
            return ResponseEntity.badRequest().body(ex.message)
        }
    }
}