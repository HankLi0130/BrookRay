package tw.hankli.brookray.core.function.intents

import android.content.Intent
import android.provider.CalendarContract

/**
 * Add a calendar event
 * https://developer.android.com/guide/components/intents-common#AddEvent
 */
fun getEventAddingIntent(
    title: String,
    location: String,
    begin: Long,
    end: Long
) = Intent(Intent.ACTION_INSERT).apply {
    data = CalendarContract.Events.CONTENT_URI
    putExtra(CalendarContract.Events.TITLE, title)
    putExtra(CalendarContract.Events.EVENT_LOCATION, location)
    putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
    putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
}