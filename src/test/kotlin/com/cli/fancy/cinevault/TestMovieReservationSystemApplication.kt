package com.cli.fancy.cinevault

import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<MovieReservationSystemApplication>().with(TestcontainersConfiguration::class).run(*args)
}
