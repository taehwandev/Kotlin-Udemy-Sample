package tech.thdev.app.view.main.home.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.thdev.app.R
import tech.thdev.app.data.Photo

/**
 * Created by record-tae on 10/22/17.
 */
class ImageViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false)
) {

    fun onBind(item: Photo) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: Photo) {
        img_view.loadImage(item.getImageUrl())
    }
}