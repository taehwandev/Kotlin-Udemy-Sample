package tech.thdev.kotlin_udemy_sample.adapter.sample_one.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.SampleItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener

/**
 * Created by tae-hwan on 10/29/16.
 */

class SampleOneViewHolder(val context: Context, parent: ViewGroup?, val onItemClickListener: OnItemClickListener?) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_text_view, parent, false)) {

    private val textView by lazy {
        itemView?.findViewById(R.id.text_view) as TextView
    }

    fun bindView(sample: SampleItem?, position: Int) {

        // OnClickListener을 구현한다
        itemView?.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }

        textView.text = sample?.message
    }
}