package tw.hankli.brookray.extension

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import kotlin.math.min
import kotlin.math.roundToInt

fun Bitmap.scale(maxSize: Int, filter: Boolean): Bitmap {
    val ratio = min(maxSize / this.width.toFloat(), maxSize / this.height.toFloat())
    val newWidth = (ratio * this.width).roundToInt()
    val newHeight = (ratio * this.height).roundToInt()
    return Bitmap.createScaledBitmap(this, newWidth, newHeight, filter)
}

fun Bitmap.toByteArray(
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
    quality: Int = 99
): ByteArray {
    ByteArrayOutputStream().apply {
        compress(format, quality, this)
        return toByteArray()
    }
}