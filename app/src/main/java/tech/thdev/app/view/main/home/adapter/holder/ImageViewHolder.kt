package tech.thdev.app.view.main.home.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app.R
import tech.thdev.app.data.Photo
import tech.thdev.app.view.custom.GlideImageView

/**
 * Created by record-tae on 10/22/17.
 */
class ImageViewHolder(
    onClick: (Int) -> Unit,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false)
) {

    init {
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    private val imgView: GlideImageView by lazy {
        itemView.findViewById(R.id.img_view)
    }

    fun onBind(item: Photo?) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: Photo?) {
        imgView.loadImage(item?.getImageUrl())
    }
}