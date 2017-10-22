package tech.thdev.app.data.source.image

import tech.thdev.app.data.ImageData
import tech.thdev.app.util.random

/**
 * Created by record-tae on 10/21/17.
 */
class ImageLocalData : ImageDataSource {

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>()
        for (index in 1..size) {
            val name = String.format("sample_%02d", (1..10).random())
            list.add(ImageData(name, name))
        }
        imageDataList(list)
    }
}