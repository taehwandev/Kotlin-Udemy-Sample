package tech.thdev.kotlin_udemy_sample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.adapter.holder.SampleOneViewHolder
import tech.thdev.kotlin_udemy_sample.adapter.model.SampleOneModel
import tech.thdev.kotlin_udemy_sample.data.SampleItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class SampleOneAdapter(private val context: Context) : RecyclerView.Adapter<SampleOneViewHolder>(), SampleOneModel {

    val itemList: MutableList<SampleItem> = ArrayList()


    var onItemClickListener: OnItemClickListener? = null
        private set

    fun setOnItemClickListner(listener: (Int) -> Unit) {

        this.onItemClickListener = object : OnItemClickListener {

            override fun onItemClick(position: Int) {
                listener(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SampleOneViewHolder {
        return SampleOneViewHolder(context, parent, onItemClickListener)
    }

    override fun onBindViewHolder(holderSample: SampleOneViewHolder?, position: Int) {
        holderSample?.bindView(getItem(position), position)
    }

    /**
     * Item size를 return
     */
    override fun getItemCount() = itemList.size

    override fun addItem(sampleItem: SampleItem) {
        itemList.add(sampleItem)
    }

    override fun getItem(position: Int) = itemList[position]

    override fun removeItem(sampleItem: SampleItem) {
        itemList.remove(sampleItem)
    }
}