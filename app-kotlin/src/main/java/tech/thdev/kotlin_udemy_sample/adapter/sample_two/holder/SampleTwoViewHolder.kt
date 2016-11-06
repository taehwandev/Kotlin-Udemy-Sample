package tech.thdev.kotlin_udemy_sample.adapter.sample_two.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.SampleItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener

/**
 * Created by tae-hwan on 10/29/16.
 */

class SampleTwoViewHolder(val context: Context, parent: ViewGroup?, val onItemClickListener: OnItemClickListener?) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_text_view, parent, false)) {

    private val rlView by lazy {
        itemView?.findViewById(R.id.rl_message_view) as RelativeLayout
    }

    private val textView by lazy {
        itemView?.findViewById(R.id.text_view) as TextView
    }

    fun bindView(sample: SampleItem?, position: Int) {
        rlView.setOnLongClickListener {
            onItemClickListener?.onItemClick(position)
            true
        }

        /*
         * item select에 따른 색상 변경
         */
        if (sample?.isSelected ?: false) {
            rlView.setBackgroundResource(R.color.color_control_highlight)
        } else {
            rlView.setBackgroundResource(0)
        }
        textView.text = sample?.message
    }
}