package tw.hankli.brookray.extension

import android.content.Context
import android.content.DialogInterface
import android.util.TypedValue
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

fun Context.getListDialog(
    @StringRes titleId: Int,
    @ArrayRes itemsId: Int,
    listener: (DialogInterface, Int) -> Unit
): AlertDialog {
    return AlertDialog.Builder(this)
        .setTitle(titleId)
        .setItems(itemsId, listener)
        .create()
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