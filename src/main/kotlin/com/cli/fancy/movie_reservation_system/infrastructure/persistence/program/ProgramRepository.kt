package com.cli.fancy.movie_reservation_system.infrastructure.persistence.program

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProgramRepository : JpaRepository<ProgramEntity, UUID> {

}