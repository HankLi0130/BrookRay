package tw.hankli.brookray.core.function.format

import java.text.SimpleDateFormat
import java.util.*

fun getDateFormat(pattern: String) = SimpleDateFormat(pattern, Locale.getDefault())