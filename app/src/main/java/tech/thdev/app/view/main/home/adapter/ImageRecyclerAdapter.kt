package tech.thdev.app.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.app.data.Photo
import tech.thdev.app.view.main.home.adapter.holder.ImageViewHolder
import tech.thdev.app.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by tae-hwan on 10/22/17.
 */
class ImageRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel {

    private val list = mutableListOf<Photo?>()

    override lateinit var onClick: (Int) -> Unit

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(onClick, context, parent)
    }

    override fun addItem(imageData: Photo?) {
        list.add(imageData)
    }

    override fun getItem(position: Int): Photo? {
        return list[position]
    }

    override fun notifyDataSetChang() {
        notifyDataSetChanged()
    }
}