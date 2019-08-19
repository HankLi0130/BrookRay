package tw.hankli.library.ext

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import tw.hankli.library.func.showMessageBySnackBar

/** 按下返回鍵 */
fun Fragment.onBackPressed() = activity?.onBackPressed()

/** 取得 Fragment 的 Class 名稱 */
fun Fragment.getSimpleName(): String = this::class.java.simpleName

/** 設定 ToolBar Title */
fun Fragment.setTitle(resId: Int) {
    activity?.setTitle(resId)
}

/** 顯示訊息使用 SnackBar */
fun Fragment.showSnackBar(message: String, duration: Int = Snackbar.LENGTH_LONG, callback: Snackbar.Callback? = null) {
    view?.let { showMessageBySnackBar(it, message, duration, callback) }
}

/** 顯示訊息使用 SnackBar */
fun Fragment.showSnackBar(resId: Int, duration: Int = Snackbar.LENGTH_LONG, callback: Snackbar.Callback? = null) {
    showSnackBar(getString(resId), duration, callback)
}

/** 顯示訊息使用 Toast */
fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    this.activity?.showToast(message, duration)
}

/** 顯示訊息使用 Toast */
fun Fragment.showToast(resId: Int, duration: Int = Toast.LENGTH_LONG) {
    showToast(getString(resId), duration)
}