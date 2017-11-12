package tech.thdev.app.view.main.home.adapter.model

import tech.thdev.app.data.Photo

/**
 * Created by tae-hwan on 10/22/17.
 */
interface ImageRecyclerModel {

    fun addItem(imageData: Photo)

    fun getItem(position: Int): Photo

    fun getItemCount(): Int

    fun notifyDataSetChang()

    var onClick: ((Int) -> Unit)?
}