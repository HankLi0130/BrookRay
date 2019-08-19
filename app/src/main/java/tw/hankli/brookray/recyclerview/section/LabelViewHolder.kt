package tw.hankli.brookray.recyclerview.section

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_label.view.*
import tw.hankli.brookray.R

class LabelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        const val LAYOUT_ID = R.layout.item_view_label
    }

    fun bind(label: String) {
        itemView.view_title.text = label
    }
}