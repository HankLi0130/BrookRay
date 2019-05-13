package tw.hankli.library.func

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/** 顯示訊息使用 SnackBar */
fun showMessageBySnackBar(
    view: View,
    message: String,
    duration: Int = Snackbar.LENGTH_LONG,
    callback: Snackbar.Callback? = null
) {
    Snackbar.make(view, message, duration).apply { callback?.let { this.addCallback(it) } }.show()
}

/** 顯示訊息使用 Toast */
fun showMessageByToast(context: Context?, message: String, duration: Int = Toast.LENGTH_LONG) {
    context?.run { Toast.makeText(this, message, duration).show() }
}