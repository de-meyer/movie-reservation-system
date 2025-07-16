package com.cli.fancy.movie_reservation_system.domain.user

import com.cli.fancy.movie_reservation_system.application.user.dto.UserLoginRequest
import com.cli.fancy.movie_reservation_system.application.user.mapper.UserMapper
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.user.AuthRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
open class UserService(private val authRepository: AuthRepository, private val userMapper: UserMapper) {
    fun getAllUsers(): List<User> = authRepository.findAll().map { userMapper.toUserDomain(it) }
    fun getUserById(id: UUID): User {
        val user = authRepository.findById(id).orElse(null)
        if (user == null) {
            throw NoSuchElementException("User with id $id not found")
        }
        return userMapper.toUserDomain(user)
    }

    fun getUserByEmail(email: String): User {
        val user = authRepository.getUserByEmail(email = email).orElse(null)
        if (user == null) {
            throw NoSuchElementException("User with email $email not found")
        }
        return userMapper.toUserDomain(user)
    }

    @Transactional
    open fun registerUser(userLoginRequest: UserLoginRequest): User {
        if (authRepository.existsByEmail(userLoginRequest.email)) {
            throw IllegalArgumentException("Email is already in use")
        }
        val user = userMapper.toLoginRequestEntity(userLoginRequest)
        val savedUser = authRepository.save(user)
        return userMapper.toUserDomain(savedUser)
    }
}