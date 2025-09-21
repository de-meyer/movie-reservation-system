package com.cli.fancy.movie_reservation_system.application.theater

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/theater")
class TheaterController {
    @GetMapping("/list")
    fun listTheaters(): List<String> {
        // This is a placeholder implementation. Replace with actual logic to fetch theaters.
        return listOf("Theater 1", "Theater 2", "Theater 3")
    }
}