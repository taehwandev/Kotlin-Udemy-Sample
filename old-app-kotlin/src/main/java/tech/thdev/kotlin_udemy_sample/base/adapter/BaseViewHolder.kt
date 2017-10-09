package tech.thdev.kotlin_udemy_sample.base.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by tae-hwan on 11/13/16.
 */

abstract class BaseViewHolder<in ITEM>(resource: Int, val context: Context, parent: ViewGroup?) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(resource, parent, false)) {

    abstract fun bindView(item: ITEM?, position: Int)
}