package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener
import tech.thdev.kotlin_udemy_sample.network.image.ImageDownloadThread

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageThreadViewHolder(
    parent: ViewGroup,
    private val onItemClickListener: OnItemClickListener?
) : BaseViewHolder<RecentPhotoItem>(R.layout.item_image_thread_view, parent) {

    private val tvTitle: TextView by lazy {
        itemView.findViewById(R.id.tv_title)
    }

    private val image: ImageView by lazy {
        itemView.findViewById(R.id.image)
    }

    init {
        itemView.setOnClickListener { onItemClickListener?.onItemClick(adapterPosition) }
    }

    override fun bindView(item: RecentPhotoItem?) {
        tvTitle.text = item?.title
        ImageDownloadThread.loadImage(R.drawable.loading, image, item?.getImageUrl())
    }
}