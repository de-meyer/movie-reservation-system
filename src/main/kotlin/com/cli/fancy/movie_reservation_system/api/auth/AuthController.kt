package com.cli.fancy.movie_reservation_system.api.auth

import com.cli.fancy.movie_reservation_system.api.model.LoginRequest
import com.cli.fancy.movie_reservation_system.api.model.LoginResponse
import com.cli.fancy.movie_reservation_system.api.model.RegisterRequest
import com.cli.fancy.movie_reservation_system.api.user.User
import com.cli.fancy.movie_reservation_system.api.user.UserService
import com.cli.fancy.movie_reservation_system.utils.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(private val userService: UserService, private val jwtUtil: JwtUtil) {

    @GetMapping
    fun getUsers(): List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User? = userService.getUserById(id)

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): ResponseEntity<String>{
        userService.registerUser(registerRequest)
        return ResponseEntity.ok("User registered successfully")
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        val user = userService.authenticateUser(request)
        val token = jwtUtil.generateToken(user.name)
        return ResponseEntity.ok(LoginResponse(token))
    }

    @GetMapping("/me")
    fun me(@RequestHeader("Authorization") token: String): ResponseEntity<User> {
        val jwt = token.replace("Bearer ", "")
        if (!jwtUtil.validateToken(jwt)) return ResponseEntity.status(401).build()
        val username = jwtUtil.getUsernameFromToken(jwt)
        val user = userService.getUserByName(username)
        return ResponseEntity.ok(user)
    }
}