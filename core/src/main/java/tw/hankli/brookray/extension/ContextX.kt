package tw.hankli.brookray.extension

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

fun Context.showListDialog(
    title: String? = null,
    cancelable: Boolean = true,
    @ArrayRes itemsId: Int,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(itemsId, listener)
        .create()
        .show()
}

fun Context.showMessageDialog(
    title: String? = null,
    message: String,
    cancelable: Boolean = true,
    @StringRes positiveText: Int,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(positiveText, listener)
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