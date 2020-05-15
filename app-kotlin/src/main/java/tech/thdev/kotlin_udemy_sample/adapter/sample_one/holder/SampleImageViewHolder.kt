package tech.thdev.kotlin_udemy_sample.adapter.sample_one.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.kotlin_udemy_sample.R

/**
 * Created by tae-hwan on 11/6/16.
 */

class SampleImageViewHolder(val context: Context, parent: ViewGroup?) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {

    private val image by lazy {
        itemView.findViewById(R.id.image_view) as ImageView
    }
}