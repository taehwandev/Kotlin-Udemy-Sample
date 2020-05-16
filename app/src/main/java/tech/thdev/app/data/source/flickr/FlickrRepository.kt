package tech.thdev.app.data.source.flickr

/**
 * Created by record-tae on 11/5/17.
 */
object FlickrRepository : FlickrDataSource {

    private val flickrRemoteData = FlickrRemoteData()

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int) =
        flickrRemoteData.getSearchPhoto(keyword, page, perPage)

    override fun getPhotoDetail(photoId: String) =
        flickrRemoteData.getPhotoDetail(photoId)
}