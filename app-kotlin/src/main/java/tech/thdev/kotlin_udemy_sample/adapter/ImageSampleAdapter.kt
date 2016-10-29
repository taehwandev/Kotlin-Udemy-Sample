package tech.thdev.kotlin_udemy_sample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.adapter.holder.ImageSampleViewHolder
import tech.thdev.kotlin_udemy_sample.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageSampleAdapter(private val context: Context) : RecyclerView.Adapter<ImageSampleViewHolder>() {

    val itemList: MutableList<ImageItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageSampleViewHolder {
        return ImageSampleViewHolder(context, parent)
    }

    override fun onBindViewHolder(holderSample: ImageSampleViewHolder?, position: Int) {
        holderSample?.bindView(getItem(position), position)
    }

    /**
     * Item list의 item을 return
     */
    private fun getItem(position: Int) = itemList.get(position)

    /**
     * Item size를 return
     */
    override fun getItemCount() = itemList.size

    fun addItem(it: ImageItem) {
        itemList.add(it)
    }
}