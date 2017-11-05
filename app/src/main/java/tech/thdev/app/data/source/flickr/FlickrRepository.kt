package tech.thdev.app.data.source.flickr

/**
 * Created by record-tae on 11/5/17.
 */
object FlickrRepository : FlickrDataSource {

    private val flickrRemoteData = FlickrRemoteData()

    override fun getRecentPhoto(page: Int, perPage: Int) = flickrRemoteData.getRecentPhoto(page, perPage)
}