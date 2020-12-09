package tw.hankli.brookray.core.extension

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import tw.hankli.brookray.core.constant.NO_RESOURCE

fun Context.showListDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @ArrayRes itemsId: Int,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    AlertDialog.Builder(this)
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(itemsId, listener)
        .create()
        .show()
}

fun Context.showListDialog(
    title: String? = null,
    items: Array<out CharSequence>,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(items, listener)
        .create()
        .show()
}

fun Context.showMessageDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @StringRes messageId: Int,
    @StringRes buttonTextId: Int,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(messageId)
        .setCancelable(cancelable)
        .setPositiveButton(buttonTextId, listener)
        .create()
        .show()
}

fun Context.showMessageDialog(
    title: String? = null,
    message: String? = null,
    buttonText: String,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(buttonText, listener)
        .create()
        .show()
}

// DP to Pixel
fun Context.dpToPx(dp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

// SP to Pixel
fun Context.spToPx(sp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics)

// DP to SP
fun Context.dpToSp(dp: Float) =
    (dpToPx(dp) / resources.displayMetrics.scaledDensity)