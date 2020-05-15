package tech.thdev.kotlin_udemy_sample.view.image.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageAsyncViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageGlideViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageThreadViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageAdapter :
    RecyclerView.Adapter<BaseViewHolder<RecentPhotoItem>>(),
    ImageViewAdapterContract.View, ImageViewAdapterContract.Model {

    companion object {
        val VIEW_TYPE_ASYNC = 100
        val VIEW_TYPE_THREAD = 200
        val VIEW_TYPE_GLIDE = 300
    }

    val itemList: ArrayList<RecentPhotoItem> = ArrayList()

    override var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecentPhotoItem> = when (viewType) {
        VIEW_TYPE_ASYNC -> ImageAsyncViewHolder(parent, onItemClickListener)
        VIEW_TYPE_THREAD -> ImageThreadViewHolder(parent, onItemClickListener)
        else -> ImageGlideViewHolder(parent, onItemClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<RecentPhotoItem>, position: Int) {
        holder.bindView(getItem(position))
    }

    override fun getItemViewType(position: Int) =
        getItem(position).viewType

    /**
     * Item size를 return
     */
    override fun getItemCount() =
        itemList.size

    override fun addItem(item: RecentPhotoItem) {
        itemList.add(item)
    }

    override fun getItems() =
        itemList

    /**
     * Item list의 item을 return
     */
    override fun getItem(position: Int) =
        itemList[position]

    override fun clear() {
        itemList.clear()
    }

    override fun reload() {
        Log.d("TAg", "reload")
        notifyDataSetChanged()
    }
}