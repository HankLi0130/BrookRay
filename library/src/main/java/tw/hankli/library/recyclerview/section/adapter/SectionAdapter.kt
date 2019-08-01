package tw.hankli.library.recyclerview.section.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tw.hankli.library.recyclerview.section.model.ItemNote

/**
 * Section Adapter
 *
 * Section 標題
 * Row 項目
 *
 * 例如：Section 高雄市 / Row 三民區、苓雅區、前鎮區、鼓山區...
 */

abstract class SectionAdapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {

    companion object {
        private const val VIEW_TYPE_SECTION = 1
        private const val VIEW_TYPE_ROW = 2
    }

    private var itemNotes: Array<ItemNote> = emptyArray()

    override fun getItemViewType(position: Int): Int {
        return if (itemNotes[position].isSection) VIEW_TYPE_SECTION else VIEW_TYPE_ROW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        return when (viewType) {
            VIEW_TYPE_SECTION -> onCreateSectionViewHolder(parent)
            VIEW_TYPE_ROW -> onCreateRowViewHolder(parent)
            else -> throw IllegalArgumentException("Not support such view type!")
        }
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        itemNotes[position].run {
            if (isSection) onBindSectionViewHolder(holder, sectionPosition)
            else onBindRowViewHolder(holder, sectionPosition, rowPosition)
        }
    }

    override fun getItemCount(): Int {
        val list = mutableListOf<ItemNote>()

        for (section in 0 until getSectionCount()) {
            list.add(ItemNote(section))

            for (row in 0 until getRowCountInSection(section)) {
                list.add(ItemNote(section, row))
            }
        }

        itemNotes = list.toTypedArray()
        return itemNotes.size
    }

    abstract fun onCreateSectionViewHolder(parent: ViewGroup): T

    abstract fun onCreateRowViewHolder(parent: ViewGroup): T

    abstract fun onBindSectionViewHolder(holder: T, section: Int)

    abstract fun onBindRowViewHolder(holder: T, section: Int, row: Int)

    abstract fun getSectionCount(): Int

    abstract fun getRowCountInSection(section: Int): Int
}