package com.cli.fancy.movie_reservation_system

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class MovieReservationSystemApplication

fun main(args: Array<String>) {
    runApplication<MovieReservationSystemApplication>(*args)
}
