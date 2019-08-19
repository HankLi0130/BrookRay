package tw.hankli.library.func

import android.view.View
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