package tech.thdev.kotlin_udemy_sample.adapter.sample_two

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.adapter.sample_two.holder.SampleTwoViewHolder
import tech.thdev.kotlin_udemy_sample.adapter.sample_two.model.SampleTwoModel
import tech.thdev.kotlin_udemy_sample.data.SampleItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class SampleTwoAdapter(private val context: Context) : RecyclerView.Adapter<SampleTwoViewHolder>(), SampleTwoModel {

    val itemList: MutableList<SampleItem> = ArrayList()

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = SampleTwoViewHolder(context, parent, onItemClickListener)

    override fun onBindViewHolder(holderSample: SampleTwoViewHolder?, position: Int) {
        holderSample?.bindView(getItem(position), position)
    }

    /**
     * Item list의 item을 return
     */
    override fun getItem(position: Int) = itemList[position]

    /**
     * Item size를 return
     */
    override fun getItemCount() = itemList.size

    override fun addItem(sampleItem: SampleItem) {
        itemList.add(sampleItem)
    }

    override fun removeItem(sampleItem: SampleItem) {
        itemList.remove(sampleItem)
    }

    override fun getItems() = itemList
}