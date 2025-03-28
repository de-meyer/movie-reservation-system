package com.cli.fancy.movie_reservation_system

import jakarta.persistence.*

@Entity
@Table(name = "users")
 class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    var name: String? = null

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    var email: String? = null
}