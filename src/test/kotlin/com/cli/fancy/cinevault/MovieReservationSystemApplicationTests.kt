package com.cli.fancy.cinevault

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class MovieReservationSystemApplicationTests {

    @Test
    @Suppress("EmptyFunctionBlock")
    fun contextLoads() {
    }
}
