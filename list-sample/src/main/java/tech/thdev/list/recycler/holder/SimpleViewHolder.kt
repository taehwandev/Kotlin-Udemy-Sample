package tech.thdev.list.recycler.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import tech.thdev.list.R

/**
 * Created by tae-hwan on 10/22/17.
 */
class SimpleViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    ) {

    fun bindView(item: String?) {
        itemView.bindView(item)
    }

    private fun View.bindView(item: String?) {
        tv_message.text = item ?: ""
    }
}