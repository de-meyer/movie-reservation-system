package com.cli.fancy.movie_reservation_system.api.user

import com.cli.fancy.movie_reservation_system.api.auth.AuthRepository
import com.cli.fancy.movie_reservation_system.api.model.LoginRequest
import com.cli.fancy.movie_reservation_system.api.model.RegisterRequest
import jakarta.transaction.Transactional
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val authRepository: AuthRepository) {
    private val passwordEncoder = BCryptPasswordEncoder()
    fun getAllUsers(): List<User> = authRepository.findAll().map { it.toDTO() }
    fun getUserById(id: Long): User? = authRepository.findById(id).orElse(null)?.toDTO()
    fun getUserByName(name: String): User? = authRepository.getUserEntityByName(name).toDTO()

    @Transactional
    fun registerUser(registerRequest: RegisterRequest): User {
        if (authRepository.existsByEmail(registerRequest.email)) {
            throw IllegalArgumentException("Email is already in use")
        }
        val user = fromRegisterRequest(registerRequest)
        val savedUser = authRepository.save(user)
        return savedUser.toDTO()
    }
    fun authenticateUser(loginRequest: LoginRequest): User {
        val userEntity = getUserByName(loginRequest.username)
            ?: throw IllegalArgumentException("User not found")
        return userEntity
    }

    private fun UserEntity.toDTO() = User(id, name!!, email!!)

    private fun User.toEntity() = UserEntity().apply {
        id = this@toEntity.id
        name = this@toEntity.name
        email = this@toEntity.email
    }
    fun fromRegisterRequest(request: RegisterRequest): UserEntity {
        return UserEntity().apply {
            name = request.username
            email = request.email
            passwordHash = passwordEncoder.encode(request.password) // Encrypt password
        }
    }
}