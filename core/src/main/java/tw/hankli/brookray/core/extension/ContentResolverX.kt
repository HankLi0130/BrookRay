package tw.hankli.brookray.core.extension

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Size
import androidx.core.graphics.scale
import tw.hankli.brookray.core.constant.ZERO

/**
 * https://stackoverflow.com/a/20208078/8361227
 * MINI_KIND: 512 x 384
 * MICRO_KIND: 96 x 96
 */

const val MINI_KIND_WIDTH = 512
const val MINI_KIND_HEIGHT = 384
const val MICRO_KIND_WIDTH = 96
const val MICRO_KIND_HEIGHT = 96

enum class ThumbnailSize(val width: Int, val height: Int) {
    MINI_KIND(MINI_KIND_WIDTH, MINI_KIND_HEIGHT),
    MICRO_KIND(MICRO_KIND_WIDTH, MICRO_KIND_HEIGHT)
}

fun ContentResolver.getImageThumbnail(
    uri: Uri,
    size: ThumbnailSize = ThumbnailSize.MICRO_KIND
): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        loadThumbnail(uri, Size(size.width, size.height), null)
    } else {
        val kind = when (size) {
            ThumbnailSize.MINI_KIND -> MediaStore.Images.Thumbnails.MINI_KIND
            ThumbnailSize.MICRO_KIND -> MediaStore.Images.Thumbnails.MICRO_KIND
        }
        val id = uri.lastPathSegment!!.toLong()
        MediaStore.Images.Thumbnails.getThumbnail(this, id, kind, BitmapFactory.Options())
    }
}

fun ContentResolver.getVideoThumbnail(
    uri: Uri,
    size: ThumbnailSize = ThumbnailSize.MICRO_KIND
): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        loadThumbnail(uri, Size(size.width, size.height), null)
    } else {
        val kind = when (size) {
            ThumbnailSize.MINI_KIND -> MediaStore.Video.Thumbnails.MINI_KIND
            ThumbnailSize.MICRO_KIND -> MediaStore.Video.Thumbnails.MICRO_KIND
        }
        val id = uri.lastPathSegment!!.toLong()
        MediaStore.Video.Thumbnails.getThumbnail(this, id, kind, BitmapFactory.Options())
    }
}

fun ContentResolver.loadImageThumbnail(
    uri: Uri,
    width: Int = MINI_KIND_WIDTH,
    height: Int = MINI_KIND_HEIGHT
): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        loadThumbnail(uri, Size(width, height), null)
    } else {
        val bitmap = MediaStore.Images.Thumbnails.getThumbnail(
            this,
            uri.lastPathSegment!!.toLong(),
            MediaStore.Images.Thumbnails.MINI_KIND,
            BitmapFactory.Options()
        )

        return if (bitmap.width != width || bitmap.height != height) {
            bitmap.scale(width, height)
        } else bitmap
    }
}

fun ContentResolver.loadVideoThumbnail(
    uri: Uri,
    width: Int = MINI_KIND_WIDTH,
    height: Int = MINI_KIND_HEIGHT
): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        loadThumbnail(uri, Size(width, height), null)
    } else {
        val bitmap = MediaStore.Video.Thumbnails.getThumbnail(
            this,
            uri.lastPathSegment!!.toLong(),
            MediaStore.Video.Thumbnails.MINI_KIND,
            BitmapFactory.Options()
        )

        return if (bitmap.width != width || bitmap.height != height) {
            bitmap.scale(width, height)
        } else bitmap
    }
}

fun ContentResolver.getBitmap(uri: Uri): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val source = ImageDecoder.createSource(this, uri)
        ImageDecoder.decodeBitmap(source)
    } else {
        openInputStream(uri).use { inputStream ->
            BitmapFactory.decodeStream(inputStream)
        }
    }
}

fun ContentResolver.getByteArray(uri: Uri): ByteArray {
    return openInputStream(uri)?.readBytes() ?: ByteArray(ZERO)
}

fun ContentResolver.getWidthAndHeight(uri: Uri): Pair<Int, Int> {
    val projection = arrayOf(
        MediaStore.Video.Media.WIDTH,
        MediaStore.Video.Media.HEIGHT
    )

    var widthAndHeight = Pair(ZERO, ZERO)

    query(uri, projection, null, null, null)
        ?.use { cursor ->
            val widthColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.WIDTH)
            val heightColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.HEIGHT)

            while (cursor.moveToNext()) {
                val width = cursor.getInt(widthColumn)
                val height = cursor.getInt(heightColumn)
                widthAndHeight = Pair(width, height)
            }
        }

    return widthAndHeight
}