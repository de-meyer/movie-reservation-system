package com.cli.fancy.movie_reservation_system

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<UserDTO> = userRepository.findAll().map { it.toDTO() }

    fun getUserById(id: Long): UserDTO? = userRepository.findById(id).orElse(null)?.toDTO()

    fun saveUser(userDTO: UserDTO): UserDTO {
        val user = userDTO.toEntity()
        return userRepository.save(user).toDTO()
    }

    fun deleteUser(id: Long) = userRepository.deleteById(id)

    private fun User.toDTO() = UserDTO(id, name!!, email!!)

    private fun UserDTO.toEntity() = User().apply {
        id = this@toEntity.id
        name = this@toEntity.name
        email = this@toEntity.email
    }
}