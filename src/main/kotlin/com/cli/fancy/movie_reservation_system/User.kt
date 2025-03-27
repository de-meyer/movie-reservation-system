import jakarta.persistence.*
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false, unique = true)
    val email: String

)
