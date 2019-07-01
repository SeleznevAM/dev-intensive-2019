package ru.skillbranch.devintensive.models

class Chat(
    val id: String,
    val memmbers: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
)