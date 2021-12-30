package tw.hankli.brookray.core.function

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
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
) = Intent(ACTION_INSERT).apply {
    data = CalendarContract.Events.CONTENT_URI
    putExtra(CalendarContract.Events.TITLE, title)
    putExtra(CalendarContract.Events.EVENT_LOCATION, location)
    putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
    putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
}

/**
 * Load a web URL
 * https://developer.android.com/guide/components/intents-common#ViewUrl
 */
fun getLoadWebUrlIntent(url: String) = Intent(ACTION_VIEW, Uri.parse(url))

/**
 * Sending text content
 * https://developer.android.com/training/sharing/send#send-text-content
 */
fun getSendTextIntent(text: String, type: String = "text/plain") = Intent().apply {
    action = ACTION_SEND
    putExtra(EXTRA_TEXT, text)
    this.type = type
}