package com.cli.fancy.movie_reservation_system.application.show

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowCreateRequest
import com.cli.fancy.movie_reservation_system.application.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.application.show.mapper.ShowMapper
import com.cli.fancy.movie_reservation_system.application.user.dto.UserLoginRequest
import com.cli.fancy.movie_reservation_system.domain.show.ShowService
import com.nimbusds.oauth2.sdk.http.HTTPResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/shows")
class ShowController(val showService: ShowService, val showMapper: ShowMapper) {
    @GetMapping("/current")
    fun getProgramForTheWeek(): List<ShowResponse> {
        return showService.getProgramForTheWeek().map { showMapper.toDto(it) }
    }
    @PostMapping("/create")
    fun createShow(@RequestBody showCreateRequest: ShowCreateRequest): ResponseEntity<String> {
        try {
            showService.mergeDateTime(showCreateRequest)
            showService.createShow(showMapper.toShowFromCreate(showCreateRequest))
            return ResponseEntity.ok().body("Success")
        }catch (ex: Exception){
            return ResponseEntity.badRequest().body(ex.message)
        }
    }
    fun getProgramById(id: UUID): ShowResponse? {
        return showService.findById(id)?.let { showMapper.toDto(it) }
    }

    @GetMapping("/all")
    fun getAllPrograms(): List<ShowResponse> {
        return showService.findAll().map { showMapper.toDto(it) }
    }

}