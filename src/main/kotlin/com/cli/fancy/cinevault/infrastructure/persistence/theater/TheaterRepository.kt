package com.cli.fancy.cinevault.infrastructure.persistence.theater

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface TheaterRepository : ReactiveCrudRepository<TheaterEntity, UUID>
