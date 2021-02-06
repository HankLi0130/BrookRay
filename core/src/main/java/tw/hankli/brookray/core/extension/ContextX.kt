package tw.hankli.brookray.core.extension

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import android.util.TypedValue
import androidx.annotation.ArrayRes
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import tw.hankli.brookray.core.constant.NO_RESOURCE

@RequiresPermission(allOf = [ACCESS_NETWORK_STATE])
fun Context.isNetworkConnected(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    return activeNetwork?.isConnected == true
}

fun Context.showListDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @ArrayRes itemsId: Int,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    AlertDialog.Builder(this)
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(itemsId, listener)
        .create()
        .show()
}

fun Context.showListDialog(
    title: String? = null,
    items: Array<out CharSequence>,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setCancelable(cancelable)
        .setItems(items, listener)
        .create()
        .show()
}

fun Context.showMessageDialog(
    @StringRes titleId: Int = NO_RESOURCE,
    @StringRes messageId: Int,
    @StringRes buttonTextId: Int,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    val title = if (titleId == NO_RESOURCE) null else getString(titleId)
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(messageId)
        .setCancelable(cancelable)
        .setPositiveButton(buttonTextId, listener)
        .create()
        .show()
}

fun Context.showMessageDialog(
    title: String? = null,
    message: String? = null,
    buttonText: String,
    cancelable: Boolean = true,
    listener: (DialogInterface, Int) -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(buttonText, listener)
        .create()
        .show()
}

// DP to Pixel
fun Context.dpToPx(dp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

// SP to Pixel
fun Context.spToPx(sp: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics)

// DP to SP
fun Context.dpToSp(dp: Float) =
    (dpToPx(dp) / resources.displayMetrics.scaledDensity)

fun Context.requestPowerManager() = getSystemService(Context.POWER_SERVICE) as PowerManager

// https://developer.android.com/reference/android/os/PowerManager#isIgnoringBatteryOptimizations(java.lang.String)
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