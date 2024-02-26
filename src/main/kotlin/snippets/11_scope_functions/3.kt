package f_11_scope_functions.s_3

class UserCreationRequest(
    val id: String,
    val name: String,
    val surname: String,
)

class UserDto(
    val userId: String,
    val firstName: String,
    val lastName: String,
)

fun UserCreationRequest.toUserDto() = UserDto(
    userId = this.id,
    firstName = this.name,
    lastName = this.surname,
)
