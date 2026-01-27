package com.cli.fancy.movie_reservation_system

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import com.cli.fancy.movie_reservation_system.testdata.TestDataHelper
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient
import org.springframework.context.annotation.Import
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Sql(scripts = ["classpath:/schema.sql"])
@Import(TestcontainersConfiguration::class)
abstract class AbstractIntegrationTest {

    @Autowired
    protected lateinit var webTestClient: WebTestClient

    @Autowired
    protected lateinit var testDataHelper: TestDataHelper

    @Autowired
    protected lateinit var movieRepository: MovieRepository

    @AfterEach
    fun cleanup() {
        movieRepository.deleteAll().block()
    }
}
