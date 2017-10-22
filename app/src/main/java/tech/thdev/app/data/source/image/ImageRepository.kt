package tech.thdev.app.data.source.image

import tech.thdev.app.data.ImageData

/**
 * Created by record-tae on 10/21/17.
 */
object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        imageLocalData.loadImageList(imageDataList, size)
    }
}