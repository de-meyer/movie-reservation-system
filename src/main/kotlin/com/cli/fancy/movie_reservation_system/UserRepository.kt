package com.cli.fancy.movie_reservation_system

import User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long>