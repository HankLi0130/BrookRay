package tw.hankli.library.recyclerview.section.model

class ItemNote(
    val sectionPosition: Int,
    val rowPosition: Int = NO_ROW_POSITION
) {
    companion object {
        const val NO_ROW_POSITION = -1
    }

    val isSection: Boolean
        get() = rowPosition == NO_ROW_POSITION
}