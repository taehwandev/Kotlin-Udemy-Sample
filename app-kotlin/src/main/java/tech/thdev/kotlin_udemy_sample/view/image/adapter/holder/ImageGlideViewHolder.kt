package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageGlideViewHolder(
    parent: ViewGroup,
    private val onItemClickListener: OnItemClickListener?
) : BaseViewHolder<RecentPhotoItem>(R.layout.item_image_view, parent) {

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
        Log.d("TAG", "item ${item?.title}")
        tvTitle.text = item?.title
        Glide.with(itemView.context)
            .load(item?.getImageUrl())
            .centerCrop()
            .placeholder(R.drawable.loading)
            .into(image)
    }
}