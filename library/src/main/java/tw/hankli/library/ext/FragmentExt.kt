package tw.hankli.library.ext

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import tw.hankli.library.func.showMessageBySnackBar
import tw.hankli.library.func.showMessageByToast
import tw.hankli.library.utils.NO_RESOURCE

/** 按下返回鍵 */
fun Fragment.onBackPressed() = activity?.onBackPressed()

/** 取得 Fragment 的 Class 名稱 */
fun Fragment.getSimpleName(): String = this::class.java.simpleName

/** 設定 ToolBar Title */
fun Fragment.setTitle(resId: Int) {
    if (resId != NO_RESOURCE) activity?.setTitle(resId)
}

/** 顯示訊息使用 SnackBar */
fun Fragment.showSnackBar(message: String, duration: Int = Snackbar.LENGTH_LONG, callback: Snackbar.Callback? = null) {
    view?.let { showMessageBySnackBar(it, message, duration, callback) }
}

/** 顯示訊息使用 SnackBar */
fun Fragment.showSnackBar(resId: Int, duration: Int = Snackbar.LENGTH_LONG, callback: Snackbar.Callback? = null) {
    view?.let {
        val message = getString(resId)
        showMessageBySnackBar(it, message, duration, callback)
    }
}

/** 顯示訊息使用 Toast */
fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    showMessageByToast(context, message, duration)
}

/** 顯示訊息使用 Toast */
fun Fragment.showToast(resId: Int, duration: Int = Toast.LENGTH_LONG) {
    val message = getString(resId)
    showToast(message, duration)
}