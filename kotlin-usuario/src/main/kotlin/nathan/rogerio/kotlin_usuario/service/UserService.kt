package nathan.rogerio.kotlin_usuario.service

import nathan.rogerio.kotlin_usuario.entity.User
import nathan.rogerio.kotlin_usuario.repository.UserRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class UserService (private val userrepository: UserRepository){

    fun getUsers(): List<User> = userrepository.findAll()

    fun addUser(user: User): User = userrepository.save(user)

    fun getUserById(id: Long):
            User = userrepository.findById(id).orElseThrow(){IllegalStateException("Usuário com o id $id não encontrado !") }

    fun updateUser(id: Long, updatedUser: User): User{
        val userExistente = getUserById(id)
        return userrepository.save(userExistente.copy(name = updatedUser.name, email = updatedUser.email))}

    fun deleteUser(id: Long) {
        val user = getUserById(id)
        userrepository.deleteById(id)
    }


}