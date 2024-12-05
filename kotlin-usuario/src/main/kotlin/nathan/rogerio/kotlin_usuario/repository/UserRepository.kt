package nathan.rogerio.kotlin_usuario.repository

import nathan.rogerio.kotlin_usuario.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}