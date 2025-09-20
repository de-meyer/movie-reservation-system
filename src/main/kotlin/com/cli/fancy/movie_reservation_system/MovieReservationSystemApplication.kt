package com.cli.fancy.movie_reservation_system

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
open class MovieReservationSystemApplication

fun main(args: Array<String>) {
    runApplication<MovieReservationSystemApplication>(*args)
}
