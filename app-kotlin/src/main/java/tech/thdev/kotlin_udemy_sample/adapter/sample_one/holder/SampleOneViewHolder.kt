package tech.thdev.kotlin_udemy_sample.adapter.sample_one.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.SampleItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener

/**
 * Created by tae-hwan on 10/29/16.
 */

class SampleOneViewHolder(
    private val context: Context,
    parent: ViewGroup?,
    private val onItemClickListener: OnItemClickListener?
) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_text_view, parent, false)
    ) {

    private val textView by lazy {
        itemView.findViewById(R.id.text_view) as TextView
    }

    fun bindView(sample: SampleItem?, position: Int) {

        // OnClickListener을 구현한다
        itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }

        textView.text = sample?.message
    }
}