package tech.thdev.kotlin_udemy_sample.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.PhotoItem

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageViewHolder(val context: Context, parent: ViewGroup?) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {

    private val imageView by lazy {
        itemView?.findViewById(R.id.image) as ImageView
    }

    fun bindView(image: PhotoItem?, position: Int) {
    }
}