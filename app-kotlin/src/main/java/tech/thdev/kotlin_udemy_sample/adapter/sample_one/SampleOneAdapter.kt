package tech.thdev.kotlin_udemy_sample.adapter.sample_one

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.adapter.sample_one.holder.SampleImageViewHolder
import tech.thdev.kotlin_udemy_sample.adapter.sample_one.holder.SampleOneViewHolder
import tech.thdev.kotlin_udemy_sample.adapter.sample_one.model.SampleOneModel
import tech.thdev.kotlin_udemy_sample.data.SampleItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener

/**
 * Created by tae-hwan on 10/29/16.
 */

class SampleOneAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), SampleOneModel {

    companion object {
        const val VIEW_TYPE_TEXT = 1
        const val VIEW_TYPE_IMAGE = 2
    }

    private val itemList: MutableList<SampleItem> = ArrayList()


    var onItemClickListener: OnItemClickListener? = null
        private set

    fun setOnItemClickListener(listener: (Int) -> Unit) {

        this.onItemClickListener = object : OnItemClickListener {

            override fun onItemClick(position: Int) {
                listener(position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_TEXT -> (holder as? SampleOneViewHolder)?.bindView(getItem(position), position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        VIEW_TYPE_IMAGE -> SampleImageViewHolder(context, parent)
        else -> SampleOneViewHolder(context, parent, onItemClickListener)
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