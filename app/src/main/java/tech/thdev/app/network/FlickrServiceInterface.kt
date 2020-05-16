package tech.thdev.app.network

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query
import tech.thdev.app.BuildConfig
import tech.thdev.app.data.PhotoInfo
import tech.thdev.app.data.PhotoResponse

/**
 * Created by record-tae on 11/5/17.
 */
interface FlickrServiceInterface {

    @POST("?method=flickr.photos.search&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrSearchPhotos(
        @Query("text") keyword: String,
        @Query("safe_search") safeSearch: Int = 1,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<PhotoResponse>

    // https://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=9c853da14ec63ea02507f1cf67545b5f&photo_id=37632503954&format=json&nojsoncallback=1&api_sig=7e8fce92b6d4630df35c2e82e542a2d4
    @POST("?method=flickr.photos.getInfo&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrPhotoDetail(
        @Query("photo_id") photoId: String
    ): Call<PhotoInfo>
}