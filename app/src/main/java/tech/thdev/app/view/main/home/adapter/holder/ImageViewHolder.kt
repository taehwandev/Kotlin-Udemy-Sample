package tech.thdev.app.view.main.home.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app.R
import tech.thdev.app.data.ImageData

/**
 * Created by record-tae on 10/22/17.
 */
class ImageViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false)
) {

    private val tvTitle: TextView by lazy {
        itemView.findViewById(R.id.tv_title)
    }

    private val imgView: ImageView by lazy {
        itemView.findViewById(R.id.img_view)
    }

    fun onBind(item: ImageData) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: ImageData) {
        tvTitle.text = item.name
        imgView.setImageResource(
            resources.getIdentifier(
                item.fileName,
                "drawable",
                context.packageName
            )
        )
    }
}