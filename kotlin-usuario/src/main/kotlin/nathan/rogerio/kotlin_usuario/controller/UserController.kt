package nathan.rogerio.kotlin_usuario.controller

import nathan.rogerio.kotlin_usuario.entity.User
import nathan.rogerio.kotlin_usuario.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/users")
class UserController (private val userService: UserService){

    @GetMapping
    fun getUsers(): List<User> = userService.getUsers()

    @PostMapping
    fun addUser(@RequestBody user: User): User = userService.addUser(user)

    @GetMapping ("/{id}")
    fun getUserByIdI(@PathVariable id: Long): User = userService.getUserById(id)

    @PutMapping ("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User = userService.updateUser(id, user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long){
        userService.deleteUser(id)
    }

}