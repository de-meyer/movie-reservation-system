package com.cli.fancy.movie_reservation_system

import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<Users, Long>