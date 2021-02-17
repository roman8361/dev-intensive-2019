package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.models.User

class Chat(
    val id: String,
    val members: MutableList<User> = mutableListOf(),
    val message: MutableList<BaseMessage> = mutableListOf()
) {
}