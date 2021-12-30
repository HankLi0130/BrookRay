package tw.hankli.brookray.core.extension

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import android.util.TypedValue
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission

// DP to Pixel
fun Context.dpToPx(dp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

// SP to Pixel
fun Context.spToPx(sp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics)

// DP to SP
fun Context.dpToSp(dp: Float) =
    (dpToPx(dp) / resources.displayMetrics.scaledDensity)

/**
 * System Service
 */

@RequiresPermission(allOf = [ACCESS_NETWORK_STATE])
fun Context.isNetworkConnected(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnected == true
}

fun Context.copyToClipboard(label: String, text: String) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, text)
    clipboard.setPrimaryClip(clip)
}

// https://developer.android.com/reference/android/os/PowerManager#isIgnoringBatteryOptimizations(java.lang.String)
fun Context.requestPowerManager() = getSystemService(Context.POWER_SERVICE) as PowerManager

@RequiresApi(api = Build.VERSION_CODES.M)
fun Context.isIgnoringBatteryOptimizations(): Boolean {
    return requestPowerManager().isIgnoringBatteryOptimizations(packageName)
}

@SuppressLint("BatteryLife")
@RequiresApi(api = Build.VERSION_CODES.M)
fun Context.requestIgnoreBatteryOptimizations() {
    val intent = Intent().apply {
        if (requestPowerManager().isIgnoringBatteryOptimizations(packageName)) {
            action = Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS
        } else {
            action = Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
            data = Uri.parse("package:$packageName")
        }
    }
    startActivity(intent)
}