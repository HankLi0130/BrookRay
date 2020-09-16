package tw.hankli.brookray.ui.recyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tw.hankli.brookray.ui.recyclerview.model.Section

/**
 * Section Adapter
 *
 * Section 包含
 * 一個 Label 標題
 * 多個 Row   項目
 *
 * 例如：Section 高雄市 / Row 三民區、苓雅區、前鎮區、鼓山區...
 */

abstract class SectionAdapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {

    companion object {
        private const val VIEW_TYPE_LABEL = 1
        private const val VIEW_TYPE_ROW = 2
    }

    private var sections: Array<Section> = emptyArray()

    override fun getItemViewType(position: Int): Int {
        return if (sections[position].isLabel) VIEW_TYPE_LABEL else VIEW_TYPE_ROW
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        return when (viewType) {
            VIEW_TYPE_LABEL -> onCreateLabelViewHolder(parent)
            VIEW_TYPE_ROW -> onCreateRowViewHolder(parent)
            else -> throw IllegalArgumentException("Not support such view type!")
        }
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        sections[position].run {
            if (isLabel) onBindLabelViewHolder(holder, this.position)
            else onBindRowViewHolder(holder, this.position, this.rowPosition)
        }
    }

    override fun getItemCount(): Int {
        val list = mutableListOf<Section>()

        for (section in 0 until getSectionCount()) {
            // Add label
            list.add(Section(section))

            // Add rows
            for (row in 0 until getRowCountInSection(section)) {
                list.add(Section(section, row))
            }
        }

        sections = list.toTypedArray()
        return sections.size
    }

    abstract fun onCreateLabelViewHolder(parent: ViewGroup): T

    abstract fun onCreateRowViewHolder(parent: ViewGroup): T

    abstract fun onBindLabelViewHolder(holder: T, section: Int)

    abstract fun onBindRowViewHolder(holder: T, section: Int, row: Int)

    abstract fun getSectionCount(): Int

    abstract fun getRowCountInSection(section: Int): Int
}