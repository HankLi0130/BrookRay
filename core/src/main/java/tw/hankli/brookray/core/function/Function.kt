package tw.hankli.brookray.core.function

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun getTimeZoneAbbreviation(): String {
    val format = DateTimeFormatter.ofPattern("O")
    return ZonedDateTime.now().format(format)
}