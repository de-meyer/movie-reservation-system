package com.cli.fancy.movie_reservation_system.api.user

import com.cli.fancy.movie_reservation_system.api.auth.AuthRepository
import com.cli.fancy.movie_reservation_system.api.model.OAuthLoginRequest
import com.cli.fancy.movie_reservation_system.api.model.LoginRequest
import jakarta.transaction.Transactional
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val authRepository: AuthRepository) {
    private val passwordEncoder = BCryptPasswordEncoder()
    fun getAllUsers(): List<User> = authRepository.findAll().map { it.toDTO() }
    fun getUserById(id: Long): User? = authRepository.findById(id).orElse(null)?.toDTO()
    fun getUserByEmail(email:String): User? = authRepository.getUserByEmail( email = email).orElse(null)?.toDTO()

    @Transactional
    fun registerUser(oAuthLoginRequest: OAuthLoginRequest): User {
        if (authRepository.existsByEmail(oAuthLoginRequest.email)) {
            throw IllegalArgumentException("Email is already in use")
        }
        val user = fromRegisterRequest(oAuthLoginRequest)
        val savedUser = authRepository.save(user)
        return savedUser.toDTO()
    }

    private fun UserEntity.toDTO() = User(id, name!!, email!!)

    private fun User.toEntity() = UserEntity().apply {
        id = this@toEntity.id
        name = this@toEntity.name
        email = this@toEntity.email
    }
    fun fromRegisterRequest(request: OAuthLoginRequest): UserEntity {
        return UserEntity().apply {
            name = request.name
            email = request.email
        }
    }
}