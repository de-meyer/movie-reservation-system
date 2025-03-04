package com.cli.fancy.movie_reservation_system

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieReservationSystemApplication

fun main(args: Array<String>) {
    runApplication<MovieReservationSystemApplication>(*args)
}
