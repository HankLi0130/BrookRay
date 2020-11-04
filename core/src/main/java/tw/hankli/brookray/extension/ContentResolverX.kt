package tw.hankli.brookray.extension

import android.annotation.TargetApi
import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Size

/**
 * https://stackoverflow.com/a/20208078/8361227
 * MINI_KIND: 512 x 384
 * MICRO_KIND: 96 x 96
 */

enum class ThumbnailSize(val width: Int, val height: Int) {
    MINI_KIND(512, 384),
    MICRO_KIND(96, 96)
}

@TargetApi(Build.VERSION_CODES.Q)
fun ContentResolver.getImageThumbnail(
    uri: Uri,
    width: Int = ThumbnailSize.MICRO_KIND.width,
    height: Int = ThumbnailSize.MICRO_KIND.height
): Bitmap {
    return loadThumbnail(uri, Size(width, height), null)
}

fun ContentResolver.getImageThumbnail(
    uri: Uri,
    size: ThumbnailSize = ThumbnailSize.MICRO_KIND
): Bitmap {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        getImageThumbnail(uri, size.width, size.height)
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
        getImageThumbnail(uri, size.width, size.height)
    } else {
        val kind = when (size) {
            ThumbnailSize.MINI_KIND -> MediaStore.Video.Thumbnails.MINI_KIND
            ThumbnailSize.MICRO_KIND -> MediaStore.Video.Thumbnails.MICRO_KIND
        }
        val id = uri.lastPathSegment!!.toLong()
        MediaStore.Video.Thumbnails.getThumbnail(this, id, kind, BitmapFactory.Options())
    }
}