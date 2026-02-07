package com.cli.fancy.movie_reservation_system.application.api.show

import com.cli.fancy.movie_reservation_system.application.api.show.dto.ShowCreateRequest
import com.cli.fancy.movie_reservation_system.application.api.show.dto.ShowIdRequest
import com.cli.fancy.movie_reservation_system.application.api.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.application.api.show.mapper.toEntity
import com.cli.fancy.movie_reservation_system.application.api.show.mapper.toShowResponse
import com.cli.fancy.movie_reservation_system.domain.show.ShowService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/show")
class ShowController(val showService: ShowService) {

    @GetMapping("/findAll")
    fun findAllShows(): Flux<ShowResponse> =
        showService.findAll().map { it.toShowResponse() }


    @PostMapping("/find")
    fun findShowById(@RequestBody request: ShowIdRequest): Mono<ShowResponse> =
        showService.findById(request.id).map { it.toShowResponse() }

    @PostMapping("/create")
    fun createShow(@RequestBody request: ShowCreateRequest): Mono<ResponseEntity<String>> =
        showService.createShow(request.toEntity())
            .map { ResponseEntity.ok().body("Success") }
}