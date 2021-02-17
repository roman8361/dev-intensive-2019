package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0) ?: "null"
        var lastName = parts?.getOrNull(1) ?: "null"
        if (firstName.isEmpty() || firstName === " ") {
            firstName = "null"
        }

        if (lastName.isEmpty() || lastName === " ") {
            lastName = "null"
        }

        return firstName to lastName
    }

    fun transliterations(payload: String, diveder: String = " "): String {
        TODO()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if (lastName == null && firstName != null) return firstName[0].toUpperCase().toString()
        if (firstName != null) {
            if (firstName.isEmpty()) return "null"
            if (lastName?.isEmpty()!!) return firstName[0].toUpperCase().toString()
            return firstName[0].toUpperCase().toString() + lastName[0].toUpperCase().toString()
        }
        return "null"
    }

}
