package com.cli.fancy.movie_reservation_system.utils

import com.cli.fancy.movie_reservation_system.api.user.PrincipalUser
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Service
class JwtService {
    private val secretKey: SecretKey = SecretKeySpec(ByteArray(48) { it.toByte() }, "HmacSHA384")
    private val expiration: Long = 3600000 // 1 hour

    fun generateToken(user: PrincipalUser): String {
        return Jwts.builder()
            .setSubject(user.email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .claim("name", user.name)
            .claim("roles", user.roles)
            .signWith(secretKey, SignatureAlgorithm.HS384)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            val claims = parseToken(token)
            !claims.body.expiration.before(Date())
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getPrincipalUserFromToken(token: String): PrincipalUser {
        val claims = parseToken(token)
        val name = claims.body["name"] as String
        val email = claims.body.subject
        val roles = (claims.body["roles"] as? List<*>)?.filterIsInstance<String>() ?: listOf()
        return PrincipalUser(name = name, email = email, roles = roles)
    }

    private fun parseToken(token: String): Jws<Claims> {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
    }
}
