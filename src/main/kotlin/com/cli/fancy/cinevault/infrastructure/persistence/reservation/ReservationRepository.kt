package com.cli.fancy.cinevault.infrastructure.persistence.reservation

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface ReservationRepository : ReactiveCrudRepository<ReservationEntity, UUID>
