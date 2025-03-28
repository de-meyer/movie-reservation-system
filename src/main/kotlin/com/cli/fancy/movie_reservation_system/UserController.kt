package com.cli.fancy.movie_reservation_system

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers(): MutableIterable<Users> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): Users? = userService.getUserById(id)

    @PostMapping
    fun createUser(@RequestBody user: Users): Users = userService.saveUser(user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)

}