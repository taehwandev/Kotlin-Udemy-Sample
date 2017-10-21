package tech.thdev.app.data.source.image

/**
 * Created by record-tae on 10/21/17.
 */
object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageFileName(fileName: (String) -> Unit) {
        imageLocalData.loadImageFileName(fileName)
    }
}