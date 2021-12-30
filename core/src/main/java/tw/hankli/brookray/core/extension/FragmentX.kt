package tw.hankli.brookray.core.extension

import android.content.DialogInterface
import android.content.Intent
import android.widget.Toast
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import tw.hankli.brookray.core.constant.NO_RESOURCE
import tw.hankli.brookray.core.function.getLoadWebUrlIntent
import tw.hankli.brookray.core.function.getSendTextIntent

fun Fragment.showListDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @ArrayRes itemsId: Int,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(itemsId, listener)
        .create()
        .show()
}

fun Fragment.showListDialog(
    title: String? = null,
    items: Array<out CharSequence>,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(items, listener)
        .create()
        .show()
}

fun Fragment.showMessageDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @StringRes messageId: Int,
    @StringRes buttonTextId: Int,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setMessage(messageId)
        .setCancelable(cancelable)
        .setPositiveButton(buttonTextId, listener)
        .create()
        .show()
}

fun Fragment.showMessageDialog(
    title: String? = null,
    message: String? = null,
    buttonText: String,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(buttonText, listener)
        .create()
        .show()
}

fun Fragment.showToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
    Toast.makeText(requireContext(), text, duration).show()

fun Fragment.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_LONG) =
    Toast.makeText(requireContext(), resId, duration).show()

fun Fragment.getContentResolver() = requireContext().contentResolver

/**
 * adding a <queries> declaration to your manifest when calling this method
 * https://developer.android.com/guide/components/intents-common#ViewUrl
 */
fun Fragment.openWebPage(url: String) {
    val intent = getLoadWebUrlIntent(url)
    if (intent.resolveActivity(requireContext().packageManager) != null) {
        startActivity(intent)
    }
}

/**
 * https://developer.android.com/training/sharing/send#send-text-content
 */
fun Fragment.shareText(text: String, type: String = "text/plain") {
    val intent = getSendTextIntent(text, type)
    val shareIntent = Intent.createChooser(intent, null)
    startActivity(shareIntent)
}