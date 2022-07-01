package tw.hankli.brookray.core.extension

import tw.hankli.brookray.core.function.getDateFormat
import java.util.*

fun Calendar.toString(pattern: String): String {
    val format = getDateFormat(pattern)
    return format.format(time)
}

fun Calendar.nowWithoutMills(): Calendar {
    clear(Calendar.MILLISECOND)
    return this
}