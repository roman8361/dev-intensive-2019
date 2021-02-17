package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName:String?) : Pair<String?, String?> {

        val parts: List<String>? = fullName?.split(" ")
        val firstName =parts?.getOrNull(0) ?: "empty fields"
        val lastName = parts?.getOrNull(1) ?: "empty fields"

//        return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliterations(payload: String, diveder: String = " ") : String {
        TODO()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO()
    }

}
