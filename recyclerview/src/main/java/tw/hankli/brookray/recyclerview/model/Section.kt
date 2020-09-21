package tw.hankli.brookray.recyclerview.model

class Section(
    val position: Int,
    val rowPosition: Int = NO_ROW_POSITION
) {
    companion object {
        const val NO_ROW_POSITION = -1
    }

    val isLabel: Boolean
        get() = rowPosition == NO_ROW_POSITION
}