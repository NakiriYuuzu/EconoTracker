package util

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Converts a Long to a date time
 * @receiver Long
 * @return LocalDateTime
 */
fun Long.toDateTime(): LocalDateTime {
    val timeZone = TimeZone.currentSystemDefault()
    val dateTime = Instant.fromEpochMilliseconds(this).toLocalDateTime(timeZone)
    return dateTime
}

/**
 * Converts a Long to a date time string with the format "yyyy/MM/dd HH:mm:ss"
 * @receiver Long
 * @return String
 */
fun Long.toDateTimeString(): String {
    val dateTime = this.toDateTime()
    return "${dateTime.year}/${dateTime.monthNumber}/${dateTime.dayOfMonth} ${dateTime.hour}:${dateTime.minute}:${dateTime.second}"
}