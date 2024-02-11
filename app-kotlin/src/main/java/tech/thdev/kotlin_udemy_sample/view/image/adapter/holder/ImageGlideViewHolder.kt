package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.PhotoItem

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageGlideViewHolder(context: Context, parent: ViewGroup) :
    BaseViewHolder<PhotoItem>(R.layout.item_image_view, context, parent) {

    private val tvTitle: TextView by lazy {
        itemView.findViewById(R.id.tv_title)
    }

    private val image: ImageView by lazy {
        itemView.findViewById(R.id.image)
    }

    override fun bindView(item: PhotoItem?, position: Int) {
        tvTitle.text = item?.title
        Glide.with(context)
            .load(item?.getImageUrl())
            .centerCrop()
            .placeholder(R.drawable.loading)
            .into(image)
    }
}