package com.cli.fancy.movie_reservation_system.api.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers(): List<UserDTO> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): UserDTO? = userService.getUserById(id)

    @PostMapping("/registration")
    fun createUser(@RequestBody userDTO: UserDTO): UserDTO = userService.saveUser(userDTO)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)
}