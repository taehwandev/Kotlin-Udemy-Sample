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

    @POST("?method=flickr.photos.getRecent&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrRecentPhotos(
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<PhotoResponse>
}