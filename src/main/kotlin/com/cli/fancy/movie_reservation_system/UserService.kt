package com.cli.fancy.movie_reservation_system

import User
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): MutableIterable<User> = userRepository.findAll()

    fun getUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun saveUser(user: User): User = userRepository.save(user)

    fun deleteUser(id: Long) = userRepository.deleteById(id)

}
