package tech.thdev.kotlin_udemy_sample.data

/**
 * Created by tae-hwan on 11/7/16.
 */

data class RecentPhotoItem(val id: String,
                           val owner: String,
                           val secret: String,
                           val server: String,
                           val farm: Long,
                           val title: String,
                           val ispublic: Long,
                           val isfriend: Long,
                           val isfamily: Long,
                            // ViewType 추가
                           var viewType: Int = 0) {

    fun getImageUrl()
            = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}