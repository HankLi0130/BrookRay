package tw.hankli.brookray.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tw.hankli.library.recyclerview.section.adapter.SectionAdapter

class DemoSectionAdapter : SectionAdapter<RecyclerView.ViewHolder>() {

    var items: Map<String, List<String>> = emptyMap()
        set(value) {
            field = value
            sections = ArrayList(items.keys).sorted()
            notifyDataSetChanged()
        }

    private var sections: List<String> = emptyList()

    override fun onCreateSectionViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(SectionViewHolder.LAYOUT_ID, parent, false)
        return SectionViewHolder(view)
    }

    override fun onCreateRowViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(RowViewHolder.LAYOUT_ID, parent, false)
        return RowViewHolder(view)
    }

    override fun onBindSectionViewHolder(holder: RecyclerView.ViewHolder, section: Int) {
        val s = sections[section]
        (holder as SectionViewHolder).bind(s)
    }

    override fun onBindRowViewHolder(holder: RecyclerView.ViewHolder, section: Int, row: Int) {
        val r = items.getValue(sections[section])[row]
        (holder as RowViewHolder).bind(r)
    }

    override fun getSectionCount(): Int {
        return sections.size
    }

    override fun getRowCountInSection(section: Int): Int {
        return items.getValue(sections[section]).size
    }
}