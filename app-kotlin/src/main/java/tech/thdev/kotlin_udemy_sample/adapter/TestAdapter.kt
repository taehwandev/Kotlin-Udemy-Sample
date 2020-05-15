package tech.thdev.kotlin_udemy_sample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.R
import java.util.*

/**
 * Created by tae-hwan on 11/8/16.
 */

class TestAdapter(val context: Context) : RecyclerView.Adapter<TestAdapter.Holder>() {

    var list: ArrayList<String>? = null

    // 상속 구현
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(context).inflate(R.layout.item_text_view, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // TODO apply을 적용해보세요
        if (holder != null) {
            holder.textView.setText(list?.get(position))
            holder.textView.setBackgroundColor(context.resources.getColor(R.color.color_selected))
        }
    }

    override fun getItemCount() = list?.size ?: 0

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView by lazy {
            itemView.findViewById(R.id.text_view) as TextView
        }
    }
}