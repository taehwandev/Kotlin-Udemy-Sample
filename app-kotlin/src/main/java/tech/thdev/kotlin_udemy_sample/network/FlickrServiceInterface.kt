package tech.thdev.kotlin_udemy_sample.network

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import tech.thdev.kotlin_udemy_sample.BuildConfig
import tech.thdev.kotlin_udemy_sample.data.PhotoResponse

/**
 * Created by tae-hwan on 11/7/16.
 */

interface FlickrServiceInterface {

    @POST("?method=flickr.interestingness.getList&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    fun getFlickrRecentPhotos(
            @Query("page") page: Int): Call<PhotoResponse>
}