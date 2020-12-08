package tw.hankli.brookray.core.extension

import android.app.Activity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/** Hide status bar */
fun Activity.hideStatusBar() =
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

/** Show status bar */
fun Activity.showStatusBar() =
    window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

/** Show light status bar, only works equal or higher than SDK 23 (Android M) */
fun Activity.showLightStatusBar() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
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
