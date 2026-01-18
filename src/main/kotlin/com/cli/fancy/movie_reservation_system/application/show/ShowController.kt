package com.cli.fancy.movie_reservation_system.application.show

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowCreateRequest
import com.cli.fancy.movie_reservation_system.application.show.dto.ShowIdRequest
import com.cli.fancy.movie_reservation_system.application.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.application.show.mapper.toEntity
import com.cli.fancy.movie_reservation_system.application.show.mapper.toShowResponse
import com.cli.fancy.movie_reservation_system.domain.show.ShowService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/show")
class ShowController(val showService: ShowService) {

    @GetMapping("/findAll")
    fun findAllShows(): ResponseEntity<List<ShowResponse>> {
        val shows = showService.findAll().map { it.toShowResponse() }
        return ResponseEntity.ok(shows)
    }

    @PostMapping("/find")
    fun findShowById(@RequestBody request: ShowIdRequest): ShowResponse {
        val show = showService.findById(request.id).toShowResponse()
        return show
    }

    @PostMapping("/create")
    fun createShow(@RequestBody request: ShowCreateRequest): ResponseEntity<String> {
        try {
            val showEntity = request.toEntity()
            showService.createShow(showEntity = showEntity)
            return ResponseEntity.ok().body("Success")
        } catch (ex: Exception) {
            return ResponseEntity.badRequest().body(ex.message)
        }
    }
}