package ru.skillbranch.devintensive.extansion

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

fun User.toUserView(): UserView {

    val nickName = Utils.transliterations("$firstName $lastName")
    val initialis = Utils.toInitials(firstName, lastName)
    val status =
        if (lastVisit == null) "Ещё ни разу не был"
        else if (isOnline) "online"
        else "Последний раз был ${lastVisit!!.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initialis = initialis,
        status = status
    )

}
