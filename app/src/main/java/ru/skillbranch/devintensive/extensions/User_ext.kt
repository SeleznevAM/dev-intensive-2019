package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUSerView() : UserView {

    val status = when{
        lastVisit == null -> "Еще ни разу не был"
        isOnline -> "online"
        else -> "Последний раз был ${lastVisit.humanizeDiff()}"
    }

    return UserView(id,
        "$firstName $lastName",
        nickName = "",
        initials = "",
        avatar = "",
        status = "" )
}