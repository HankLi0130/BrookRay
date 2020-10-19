package tw.hankli.brookray.extension

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

fun Context.showListDialog(
    @StringRes titleId: Int,
    @ArrayRes itemsId: Int,
    listener: (DialogInterface, Int) -> Unit,
    cancelable: Boolean = true
) {
    AlertDialog.Builder(this)
        .setTitle(titleId)
        .setItems(itemsId, listener)
        .setCancelable(cancelable)
        .create()
        .show()
}

fun Context.showMessageDialog(
    title: String? = null,
    message: String,
    @StringRes positiveText: Int,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
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