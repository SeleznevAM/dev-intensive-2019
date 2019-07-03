package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits): Date {

    var localTime = this.time

    localTime += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = localTime
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val delta = date.time - time
    return when {
        delta / MINUTE < 60 -> "Проверяем минут"
        delta / HOUR < 24 -> "Проверяем часы"
        delta / DAY < 30 -> "Проверяем дни"
        delta / DAY < 30 -> "Проверяем дни"
        delta / DAY > 365 -> "Юольше года назад"
        else -> ""
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}