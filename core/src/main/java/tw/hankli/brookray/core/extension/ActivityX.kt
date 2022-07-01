package tw.hankli.brookray.core.extension

import androidx.appcompat.app.AppCompatActivity
import tw.hankli.brookray.core.function.getLoadWebUrlIntent

/**
 * adding a <queries> declaration to your manifest when calling this method
 * https://developer.android.com/training/package-visibility/use-cases#check-browser-available
 */
fun AppCompatActivity.openWebPage(url: String) {
    val intent = getLoadWebUrlIntent(url)
    if (intent.resolveActivity(this.packageManager) != null) {
        startActivity(intent)
    }
}
