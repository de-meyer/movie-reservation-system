package com.cli.fancy.movie_reservation_system.utils

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class JwtUtil {
    private val secretKey: SecretKey = SecretKeySpec(ByteArray(48) { it.toByte() }, "HmacSHA384")
    private val expiration: Long = 3600000 // 1 hour

    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(secretKey, SignatureAlgorithm.HS384)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getUsernameFromToken(token: String): String {
        val claims: Claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).body
        return claims.subject
    }
}
