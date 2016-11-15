package tech.thdev.kotlin_udemy_sample.data

/**
 * Created by tae-hwan on 11/13/16.
 */

data class FlickrPhoto(val id: String,
                       val secret: String,
                       val server: String,
                       val farm: Int,
                       val dateuploaded: String,
                       val owner: FlickrOwner,
                       val title: FlickrContent,
                       val description: FlickrContent,
                       val dates: FlickrDates,
                       val comments: FlickrContent,
                       val views: String,
                       val urls: FlickrUrls,
                       val media: String) {

    /**
     * API : <a href="https://www.flickr.com/services/api/misc.urls.html">Photo source url</a>
     * https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
     */
    fun getImageUrl()
            = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}