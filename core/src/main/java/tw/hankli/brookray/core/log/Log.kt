package tw.hankli.brookray.core.log

import android.util.Log

const val TAG = "BrookRay"

fun logInfo(message: String) = Log.i(TAG, message)

fun logErr(message: String? = null, err: Throwable) = Log.e(TAG, message, err)