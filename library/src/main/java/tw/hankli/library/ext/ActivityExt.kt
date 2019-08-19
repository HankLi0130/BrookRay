package tw.hankli.library.ext

import android.app.Activity
import android.content.DialogInterface
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import tw.hankli.library.func.showMessageBySnackBar

/*
 ** Activity **
 */

/** 狀態欄（最上面有訊號跟電池圖示的頂部欄） */
fun Activity.hideStatusBar(hide: Boolean = false) {
    val flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
    if (hide) window.addFlags(flags) else window.clearFlags(flags)
}

/** 顯示 Light Theme 的狀態欄 */
fun Activity.showLightStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}

/** 設定狀態欄顏色 */
fun Activity.setStatusBarColor(color: Int) {
    window.statusBarColor = color
}

/*
 ** AppCompatActivity **
 */

/** 顯示返回鍵 */
fun AppCompatActivity.showHomeAsUp(show: Boolean = false) {
    supportActionBar?.run { setDisplayHomeAsUpEnabled(show) }
}

/** 隱藏 ToolBar */
fun AppCompatActivity.hideActionBar(hide: Boolean = false) {
    supportActionBar?.run { if (hide) hide() else show() }
}

/*
 ** FragmentActivity **
 */

/** 顯示訊息使用 SnackBar */
fun FragmentActivity.showSnackBar(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG,
    callback: Snackbar.Callback? = null
) {
    showMessageBySnackBar(findViewById(android.R.id.content), message, duration, callback)
}

/** 顯示訊息使用 SnackBar */
fun FragmentActivity.showSnackBar(
    resId: Int,
    duration: Int = Snackbar.LENGTH_LONG,
    callback: Snackbar.Callback? = null
) {
    showSnackBar(getString(resId), duration, callback)
}

/** 顯示訊息使用 Toast */
fun FragmentActivity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

/** 顯示訊息使用 Toast */
fun FragmentActivity.showToast(resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    showToast(getString(resId), duration)
}

/** 顯示列表 Dialog */
fun FragmentActivity.getListDialog(
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

/** 顯示列表 Dialog */
fun FragmentActivity.getListDialog(
    titleId: Int,
    itemsId: Int,
    listener: DialogInterface.OnClickListener,
    cancelable: Boolean = false
): AlertDialog {
    return AlertDialog.Builder(this)
        .setTitle(titleId)
        .setItems(itemsId, listener)
        .setCancelable(cancelable)
        .create()
}

/** 顯示訊息 Dialog */
fun FragmentActivity.getMessageDialog(
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

/** 顯示訊息 Dialog */
fun FragmentActivity.getMessageDialog(
    titleId: Int, messageId: Int,
    positiveText: String, positiveListener: DialogInterface.OnClickListener,
    neutralText: String? = null, neutralListener: DialogInterface.OnClickListener? = null,
    negativeText: String? = null, negativeListener: DialogInterface.OnClickListener? = null,
    cancelable: Boolean = false
): AlertDialog {
    val builder = AlertDialog.Builder(this)
        .setTitle(titleId)
        .setMessage(messageId)
        .setCancelable(cancelable)
        .setPositiveButton(positiveText, positiveListener)

    neutralListener?.let { builder.setNeutralButton(neutralText, it) }
    negativeListener?.let { builder.setNegativeButton(negativeText, it) }

    return builder.create()
}