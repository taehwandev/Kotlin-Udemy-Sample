package tech.thdev.app.data.source.flickr

import retrofit2.Call
import tech.thdev.app.data.PhotoResponse

/**
 * Created by record-tae on 11/5/17.
 */
interface FlickrDataSource {

    fun getRecentPhoto(page: Int, perPage: Int): Call<PhotoResponse>
}