package tech.thdev.app.data.source.flickr

import tech.thdev.app.network.FlickrServiceInterface
import tech.thdev.app.network.createRetrofit

/**
 * Created by record-tae on 11/5/17.
 */
class FlickrRemoteData : FlickrDataSource {

    companion object {
        const val FLICKR_URL = "https://api.flickr.com/services/rest/"
    }

    private val flickrServiceInterface = createRetrofit(FlickrServiceInterface::class.java, FLICKR_URL)

    override fun getRecentPhoto(page: Int, perPage: Int) = flickrServiceInterface.getFlickrRecentPhotos(page, perPage)
}