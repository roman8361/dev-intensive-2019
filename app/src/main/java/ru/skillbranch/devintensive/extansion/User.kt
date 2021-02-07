package ru.kravchenko.devintensive.extansion

import ru.kravchenko.devintensive.models.User
import ru.kravchenko.devintensive.models.UserView
import ru.kravchenko.devintensive.utils.Utils

fun User.toUserView(): UserView {

    val nickName = Utils.transliterations("$firstName $lastName")
    val initialis = Utils.toInitials(firstName, lastName)
    val status =
        if (lastVisit == null) "Ещё ни разу не был"
        else if (isOnline) "online"
        else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initialis = initialis,
        status = status
    )
}
