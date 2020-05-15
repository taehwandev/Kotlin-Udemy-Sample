package tech.thdev.kotlin_udemy_sample.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by tae-hwan on 11/13/16.
 */

abstract class BaseViewHolder<in ITEM>(resource: Int, parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(resource, parent, false)) {

    abstract fun bindView(item: ITEM?)
}