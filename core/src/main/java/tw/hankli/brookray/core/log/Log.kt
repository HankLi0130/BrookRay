package tw.hankli.brookray.core.log

import android.util.Log

const val TAG = "BrookRay"

fun logInfo(message: String) = Log.i(TAG, message)

fun logInfo(message: String?, e: Throwable?) = Log.i(TAG, message, e)

fun logWarn(message: String) = Log.w(TAG, message)

fun logError(message: String) = Log.e(TAG, message)

fun logError(message: String? = null, error: Throwable?) = Log.e(TAG, message, error)