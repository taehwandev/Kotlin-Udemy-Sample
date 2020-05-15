package tech.thdev.kotlin_udemy_sample.view.image.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.PhotoItem
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageAsyncViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageGlideViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageThreadViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageAdapter(private val context: Context) :
        RecyclerView.Adapter<BaseViewHolder<PhotoItem>>(),
        ImageViewAdapterContract.View, ImageViewAdapterContract.Model {

    companion object {
        const val VIEW_TYPE_ASYNC = 100
        const val VIEW_TYPE_THREAD = 200
        const val VIEW_TYPE_GLIDE = 300
    }

    private val itemList: MutableList<PhotoItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PhotoItem> = when (viewType) {
        VIEW_TYPE_ASYNC -> ImageAsyncViewHolder(context, parent)
        VIEW_TYPE_THREAD -> ImageThreadViewHolder(context, parent)
        else -> ImageGlideViewHolder(context, parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<PhotoItem>, position: Int) {
        holder.bindView(getItem(position), position)
    }

    override fun getItemViewType(position: Int) =
        getItem(position).viewType

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

    override fun addItem(item: PhotoItem) {
        itemList.add(item)
    }

    override fun clear() {
        itemList.clear()
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}