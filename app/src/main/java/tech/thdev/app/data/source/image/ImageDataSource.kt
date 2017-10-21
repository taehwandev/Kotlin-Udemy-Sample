package tech.thdev.app.data.source.image

/**
 * Created by record-tae on 10/21/17.
 */
interface ImageDataSource {

    fun loadImageFileName(fileName: (String) -> Unit)
}