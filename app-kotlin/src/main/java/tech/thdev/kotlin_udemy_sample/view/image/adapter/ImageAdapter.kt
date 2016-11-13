package tech.thdev.kotlin_udemy_sample.view.image.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageViewHolder
import tech.thdev.kotlin_udemy_sample.data.PhotoItem
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageAdapter(private val context: Context) :
        RecyclerView.Adapter<ImageViewHolder>(),
        ImageViewAdapterContract.View, ImageViewAdapterContract.Model {

    val itemList: MutableList<PhotoItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageViewHolder {
        return ImageViewHolder(context, parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder?, position: Int) {
        holder?.bindView(getItem(position), position)
    }

    /**
     * Item list의 item을 return
     */
    private fun getItem(position: Int) = itemList.get(position)

    /**
     * Item size를 return
     */
    override fun getItemCount() = itemList.size

    fun addItem(it: PhotoItem) {
        itemList.add(it)
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}