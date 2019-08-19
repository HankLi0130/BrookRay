package tw.hankli.library.ext

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

/** 顯示列表 Dialog */
fun Context.getListDialog(
    title: String? = null,
    items: Array<out CharSequence>,
    listener: DialogInterface.OnClickListener,
    cancelable: Boolean = false
): AlertDialog {
    return AlertDialog.Builder(this)
        .setTitle(title)
        .setItems(items, listener)
        .setCancelable(cancelable)
        .create()
}

/** 顯示訊息 Dialog */
fun Context.getMessageDialog(
    title: String? = null, message: String? = null,
    positiveText: String, positiveListener: DialogInterface.OnClickListener,
    neutralText: String? = null, neutralListener: DialogInterface.OnClickListener? = null,
    negativeText: String? = null, negativeListener: DialogInterface.OnClickListener? = null,
    cancelable: Boolean = false
): AlertDialog {
    val builder = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(positiveText, positiveListener)

    neutralListener?.let { builder.setNeutralButton(neutralText, it) }
    negativeListener?.let { builder.setNegativeButton(negativeText, it) }

    return builder.create()
}

/** 顯示訊息使用 Toast */
fun Context.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}