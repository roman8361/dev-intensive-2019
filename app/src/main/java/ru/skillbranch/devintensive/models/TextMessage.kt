package ru.skillbranch.devintensive.models

import java.util.*

class TextMessage(
    id: String,
    from: User?,
    char: Chat,
    isIncome: Boolean = false,
    date: Date = Date(),
    var text: String?

) : BaseMessage(id, from, char, isIncome, date) {

    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
            "${if(isIncome) "получил" else "отправил"} сообщение \"$text\" ${date}"



}
