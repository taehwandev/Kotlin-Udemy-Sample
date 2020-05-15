package tech.thdev.kotlin_udemy_sample.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.adapter.holder.ImageSampleViewHolder
import tech.thdev.kotlin_udemy_sample.data.ImageItem

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageSampleAdapter(private val context: Context) : RecyclerView.Adapter<ImageSampleViewHolder>() {

    val itemList: MutableList<ImageItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSampleViewHolder {
        return ImageSampleViewHolder(context, parent)
    }

    override fun onBindViewHolder(holder: ImageSampleViewHolder, position: Int) {
        holder?.bindView(getItem(position), position)
    }

    /**
     * Item list의 item을 return
     */
    private fun getItem(position: Int) =
        itemList[position]

    /**
     * Item size를 return
     */
    override fun getItemCount() =
        itemList.size

    fun addItem(it: ImageItem) {
        itemList.add(it)
    }
}