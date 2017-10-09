package tech.thdev.kotlin_udemy_sample.network

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import tech.thdev.kotlin_udemy_sample.BuildConfig
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoResponse

/**
 * Created by tae-hwan on 11/7/16.
 */

interface FlickrServiceInterface {

    @POST("?method=flickr.interestingness.getList&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    fun getFlickrRecentPhotos(
            @Query("page") page: Int): Call<RecentPhotoResponse>

    // https://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=0bde4e6810b2f5295df2270bc9ceda8e&photo_id=30930664135&format=json&nojsoncallback=1
    @POST("?method=flickr.photos.getInfo&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    fun getPhotoInfo(@Query("photo_id") photoId: String): Call<FlickrInfo>
}