package tech.thdev.app.network

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import tech.thdev.app.BuildConfig
import tech.thdev.app.data.PhotoResponse

/**
 * Created by record-tae on 11/5/17.
 */
interface FlickrServiceInterface {

    @POST("?method=flickr.interestingness.getList&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    fun getFlickrRecentPhotos(
            @Query("page") page: Int): Call<PhotoResponse>
}