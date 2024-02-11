package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.PhotoItem
import tech.thdev.kotlin_udemy_sample.network.image.ImageDownloadThread

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageViewHolder(val context: Context, parent: ViewGroup?) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)
    ) {

    private val tvTitle: TextView? by lazy {
        itemView?.findViewById(R.id.tv_title)
    }

    private val image: ImageView? by lazy {
        itemView?.findViewById(R.id.image)
    }

    fun bindView(item: PhotoItem?, position: Int) {
        tvTitle?.text = item?.id
        image?.let {
            ImageDownloadThread.loadImage(R.drawable.loading, it, item?.getImageUrl())
        }
    }
}