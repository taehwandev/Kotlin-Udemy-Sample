package tech.thdev.kotlin_udemy_sample.data.model

import tech.thdev.kotlin_udemy_sample.network.FlickrServiceInterface
import tech.thdev.kotlin_udemy_sample.network.createRetrofit

/**
 * Created by tae-hwan on 11/7/16.
 */

object PhotoDataSource {

    val FLICKR_URL = "https://api.flickr.com/services/rest/"

    private val flickrServiceInterface: FlickrServiceInterface

    init {
        flickrServiceInterface = createRetrofit(FlickrServiceInterface::class.java, FLICKR_URL)
    }

    /**
     * Flickr 아이템을 불러온다
     */
    fun getRecentPhoto(page: Int) = flickrServiceInterface.getFlickrRecentPhotos(page)

    /**
     * Flickr Photo의 상세 정보를 불러온다
     */
    fun getPhotoInfo(photoId: String) = flickrServiceInterface.getPhotoInfo(photoId)
}