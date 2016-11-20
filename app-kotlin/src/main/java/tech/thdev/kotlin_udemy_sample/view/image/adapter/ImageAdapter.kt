package tech.thdev.kotlin_udemy_sample.view.image.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemTouchListener
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageAsyncViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageGlideViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageThreadViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageAdapter(private val context: Context) :
        RecyclerView.Adapter<BaseViewHolder<RecentPhotoItem>>(),
        ImageViewAdapterContract.View, ImageViewAdapterContract.Model {

    companion object {
        val VIEW_TYPE_ASYNC = 100
        val VIEW_TYPE_THREAD = 200
        val VIEW_TYPE_GLIDE = 300
    }

    val itemList: ArrayList<RecentPhotoItem> = ArrayList()

    override var onItemTouchListener: OnItemTouchListener? = null

    override fun setOnItemTouchListener(onTouch: (MotionEvent?, Int) -> Boolean) {
        onItemTouchListener = object : OnItemTouchListener {

            override fun onItemTouch(motionEvent: MotionEvent?, position: Int): Boolean {
                return onTouch(motionEvent, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = when (viewType) {
        VIEW_TYPE_ASYNC -> ImageAsyncViewHolder(context, parent, onItemTouchListener)
        VIEW_TYPE_THREAD -> ImageThreadViewHolder(context, parent, onItemTouchListener)
        else -> ImageGlideViewHolder(context, parent, onItemTouchListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<RecentPhotoItem>?, position: Int) {
        holder?.bindView(getItem(position), position)
    }

    override fun getItemViewType(position: Int) = getItem(position).viewType

    /**
     * Item size를 return
     */
    override fun getItemCount() = itemList.size

    override fun addItem(item: RecentPhotoItem?) {
        item?.let { itemList.add(it) }
    }

    override fun getItems() = itemList

    /**
     * Item list의 item을 return
     */
    override fun getItem(position: Int) = itemList[position]

    override fun clear() {
        itemList.clear()
    }

    override fun reload() {
        Log.d("TAg", "reload")
        notifyDataSetChanged()
    }
}