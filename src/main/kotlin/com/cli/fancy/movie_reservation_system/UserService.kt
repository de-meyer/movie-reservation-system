package com.cli.fancy.movie_reservation_system

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): MutableIterable<Users> = userRepository.findAll()

    fun getUserById(id: Long): Users? = userRepository.findById(id).orElse(null)

    fun saveUser(user: Users): Users = userRepository.save(user)

    fun deleteUser(id: Long) = userRepository.deleteById(id)

}
