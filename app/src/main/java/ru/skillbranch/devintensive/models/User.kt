package ru.kravchenko.devintensive.models

import ru.kravchenko.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Ford $id")

//    init {
//        println("Hello my name is: $firstName $lastName")
//    }

//

    companion object Factory{
        private var lastId : Int = -1

        fun makeUser(fullName:String?): User {
            lastId++

//            val parts: List<String>? = fullName?.split(" ")
//            val firstName =parts?.getOrNull(0) ?: "empty fields"
//            val lastName = parts?.getOrNull(1) ?: "empty fields"
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id="$lastId", firstName = firstName, lastName = lastName)
        }
    }

}