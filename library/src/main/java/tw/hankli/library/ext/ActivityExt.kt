package tw.hankli.library.ext

import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import tw.hankli.library.func.showMessageBySnackBar
import tw.hankli.library.func.showMessageByToast

/** 顯示返回鍵 */
fun AppCompatActivity.showHomeAsUp(show: Boolean = false) {
    supportActionBar?.run { setDisplayHomeAsUpEnabled(show) }
}

/** 狀態欄（最上面有訊號跟電池圖示的頂部欄） */
fun AppCompatActivity.hideStatusBar(hide: Boolean = false) {

    val flags = WindowManager.LayoutParams.FLAG_FULLSCREEN

    if (hide) window.addFlags(flags) else window.clearFlags(flags)
}

/** 顯示 Light Theme 的狀態欄 */
fun AppCompatActivity.showLightStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}

/** 設定狀態欄顏色 */
fun AppCompatActivity.setStatusBarColor(color: Int) {
    window.statusBarColor = color
}

/** 隱藏 ToolBar */
fun AppCompatActivity.hideActionBar(hide: Boolean = false) {
    supportActionBar?.run { if (hide) hide() else show() }
}

/** 顯示訊息使用 SnackBar */
fun AppCompatActivity.showSnackBar(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG,
    callback: Snackbar.Callback? = null
) {
    val view = findViewById<View>(android.R.id.content)
    showMessageBySnackBar(view, message, duration, callback)
}

/** 顯示訊息使用 SnackBar */
fun AppCompatActivity.showSnackBar(
    resId: Int,
    duration: Int = Snackbar.LENGTH_LONG,
    callback: Snackbar.Callback? = null
) {
    val message = getString(resId)
    showSnackBar(message, duration, callback)
}

/** 顯示訊息使用 Toast */
fun AppCompatActivity.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    showMessageByToast(this, message, duration)
}

/** 顯示訊息使用 Toast */
fun AppCompatActivity.showToast(resId: Int, duration: Int = Toast.LENGTH_LONG) {
    val message = getString(resId)
    showToast(message, duration)
}