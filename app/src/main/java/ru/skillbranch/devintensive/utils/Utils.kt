package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val tempName = fullName?.trim()
        val parts = tempName?.split(" ")

        return when{
            tempName.isNullOrEmpty() -> { null to null }
            else -> {
                parts?.getOrNull(0) to parts?.getOrNull(1)
            }
        }
    }

    fun toInitials(firstName : String?, lastName: String?) : String?{
        if(firstName?.isEmptyOrBlank() == true && lastName?.isEmptyOrBlank() == true) return null
        if(lastName == null && firstName == null) return null
        if(lastName == null) return firstName?.get(0).toString()
        if(firstName == null) return lastName[0].toString()
        return "${firstName[0].toString().toUpperCase()}${ lastName[0].toString().toUpperCase()}"
    }

    fun String?.isEmptyOrBlank() : Boolean = this?.isEmpty() == true || this?.isBlank() == true



}