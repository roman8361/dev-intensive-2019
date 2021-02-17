package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.models.User
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    char: Chat,
    isIncome: Boolean = false,
    date: Date = Date(),
    var image: String?

) : BaseMessage(id, from, char, isIncome, date) {

    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
            "${if(isIncome) "получил" else "отправил"} изображение \"$image\" ${date}"

}
