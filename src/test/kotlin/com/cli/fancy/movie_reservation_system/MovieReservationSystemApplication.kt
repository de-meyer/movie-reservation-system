package com.cli.fancy.movie_reservation_system

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<MovieReservationSystemApplication>().with(TestcontainersConfiguration::class).run(*args)
}
