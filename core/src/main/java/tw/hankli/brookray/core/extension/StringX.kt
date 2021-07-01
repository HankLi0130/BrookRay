package tw.hankli.brookray.core.extension

fun String.asciiToByteArray() = ByteArray(length) {
    get(it).code.toByte()
}