package tech.thdev.app.view.main.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app.data.ImageData
import tech.thdev.app.view.main.home.adapter.holder.ImageViewHolder
import tech.thdev.app.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by tae-hwan on 10/22/17.
 */
class ImageRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel {

    private val list = mutableListOf<ImageData>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(parent)
    }

    override fun addItem(imageData: ImageData) {
        list.add(imageData)
    }

    override fun notifyDataSetChang() {
        notifyDataSetChanged()
    }
}