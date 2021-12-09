package tw.hankli.brookray.core.extension

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

private fun Activity.getWindowInsetsController(): WindowInsetsControllerCompat? =
    ViewCompat.getWindowInsetsController(window.decorView)

/** Hide status bar */
fun Activity.hideStatusBar() {
    getWindowInsetsController()?.run { hide(WindowInsetsCompat.Type.statusBars()) }
}

/** Show status bar */
fun Activity.showStatusBar() {
    getWindowInsetsController()?.run { show(WindowInsetsCompat.Type.statusBars()) }
}

/** Show light status bar, only works equal or higher than SDK 23 (Android M) */
fun Activity.showLightStatusBar() {
    getWindowInsetsController()?.run { isAppearanceLightStatusBars = true }
}

/** Set status bar color */
fun Activity.setStatusBarColor(color: Int) {
    window.statusBarColor = color
}

/** Show home button on toolbar */
fun AppCompatActivity.showHomeAsUp(show: Boolean = false) {
    supportActionBar?.run { setDisplayHomeAsUpEnabled(show) }
}

/** Hide ToolBar */
fun AppCompatActivity.hideActionBar() = supportActionBar?.hide()

/** Show ToolBar */
fun AppCompatActivity.showActionBar() = supportActionBar?.show()
