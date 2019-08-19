package tw.hankli.brookray.recyclerview.section

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_row.view.*
import tw.hankli.brookray.R

class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        const val LAYOUT_ID = R.layout.item_view_row
    }

    fun bind(row: String) {
        itemView.view_item.text = row
    }
}