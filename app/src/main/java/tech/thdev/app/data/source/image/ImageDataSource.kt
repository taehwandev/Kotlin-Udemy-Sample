package tech.thdev.app.data.source.image

import tech.thdev.app.data.ImageData

/**
 * Created by record-tae on 10/21/17.
 */
interface ImageDataSource {

    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}