package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemTouchListener

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageGlideViewHolder(
    parent: ViewGroup,
    private val onItemTouchListener: OnItemTouchListener?
) : BaseViewHolder<RecentPhotoItem>(R.layout.item_image_view, parent) {

    private val image: ImageView by lazy {
        itemView.findViewById(R.id.image)
    }

    init {
        itemView.setOnTouchListener { _, motionEvent ->
            onItemTouchListener?.onItemTouch(motionEvent, adapterPosition) ?: false
        }
    }

    override fun bindView(item: RecentPhotoItem?) {
        Glide.with(itemView.context)
            .load(item?.getImageUrl())
            .centerCrop()
            .placeholder(R.drawable.loading)
            .into(image)
    }
}