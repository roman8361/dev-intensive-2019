package ru.skillbranch.devintensive.models

data class UserView(
    val id: String,
    val fullName : String,
    val nickName : String,
    val avatar : String? = null,
    val status : String? = "offline",
    val initialis : String?
) {
    fun printMe() {
        """
            id: {$id}
            fullName : {$fullName}
            nickName : {$nickName}
            avatar : {$avatar}
            status : {$status}
            initialis : {$initialis}
        """.trimIndent()
    }

}