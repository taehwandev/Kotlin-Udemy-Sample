package tech.thdev.list_view.recycler.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.list_sample.R

/**
 * Created by tae-hwan on 10/22/17.
 */
class SimpleViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    ) {

    private val tvMessage: TextView by lazy {
        itemView.findViewById(R.id.tv_message)
    }

    fun bindView(item: String?) {
        itemView.bindView(item)
    }

    private fun View.bindView(item: String?) {
        tvMessage.text = item ?: ""
    }
}