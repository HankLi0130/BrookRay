package tw.hankli.brookray.core.function

import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun getTimeZoneAbbreviation(): String {
    val format = DateTimeFormatter.ofPattern("O")
    return ZonedDateTime.now().format(format)
}

fun getDateFormat(pattern: String) = SimpleDateFormat(pattern, Locale.getDefault())