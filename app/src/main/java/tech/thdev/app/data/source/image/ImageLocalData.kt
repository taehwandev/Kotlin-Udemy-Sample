package tech.thdev.app.data.source.image

import tech.thdev.app.util.random

/**
 * Created by record-tae on 10/21/17.
 */
class ImageLocalData : ImageDataSource {

    override fun loadImageFileName(fileName: (String) -> Unit) {
        fileName(String.format("sample_%02d", (1..10).random()))
    }
}