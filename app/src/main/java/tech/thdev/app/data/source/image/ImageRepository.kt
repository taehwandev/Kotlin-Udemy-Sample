package tech.thdev.app.data.source.image

import tech.thdev.app.data.ImageData

/**
 * Created by record-tae on 10/21/17.
 */
object ImageRepository : ImageDataSource {

    private val IMAGE_REMOTE_DATA: ImageRemoteData by lazy {
        ImageRemoteData()
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        IMAGE_REMOTE_DATA.loadImageList(imageDataList, size)
    }
}