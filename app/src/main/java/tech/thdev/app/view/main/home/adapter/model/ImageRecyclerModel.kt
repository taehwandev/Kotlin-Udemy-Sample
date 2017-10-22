package tech.thdev.app.view.main.home.adapter.model

import tech.thdev.app.data.ImageData

/**
 * Created by tae-hwan on 10/22/17.
 */
interface ImageRecyclerModel {

    fun addItem(imageData: ImageData)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}