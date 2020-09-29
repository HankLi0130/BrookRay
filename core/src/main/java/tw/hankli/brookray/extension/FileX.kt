package tw.hankli.brookray.extension

import java.io.File
import java.io.InputStream

/** Transfer InputStream into File */
fun File.copyInputStreamToFile(inputStream: InputStream) {
    inputStream.use { input ->
        this.outputStream().use { fileOut ->
            input.copyTo(fileOut)
        }
    }
}