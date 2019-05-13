package tw.hankli.library.ext

import java.io.File
import java.io.InputStream

/** 將 InputStream 寫入 File */
fun File.copyInputStreamToFile(inputStream: InputStream) {
    inputStream.use { input ->
        this.outputStream().use { fileOut ->
            input.copyTo(fileOut)
        }
    }
}