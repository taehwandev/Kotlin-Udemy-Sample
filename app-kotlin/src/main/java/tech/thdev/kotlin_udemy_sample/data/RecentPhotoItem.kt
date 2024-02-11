package tech.thdev.kotlin_udemy_sample.data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by tae-hwan on 11/7/16.
 */

data class RecentPhotoItem(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Long,
    val title: String,
    val ispublic: Long,
    val isfriend: Long,
    val isfamily: Long,
    // ViewType 추가
    var viewType: Int = 0
) : Parcelable {
    /**
     * API : <a href="https://www.flickr.com/services/api/misc.urls.html">Photo source url</a>
     * https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
     */
    fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RecentPhotoItem> =
            object : Parcelable.Creator<RecentPhotoItem> {
                override fun createFromParcel(source: Parcel): RecentPhotoItem =
                    RecentPhotoItem(source)

                override fun newArray(size: Int): Array<RecentPhotoItem?> = arrayOfNulls(size)
            }
    }

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readLong(),
        source.readString()!!,
        source.readLong(),
        source.readLong(),
        source.readLong(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(owner)
        dest?.writeString(secret)
        dest?.writeString(server)
        dest?.writeLong(farm)
        dest?.writeString(title)
        dest?.writeLong(ispublic)
        dest?.writeLong(isfriend)
        dest?.writeLong(isfamily)
        dest?.writeInt(viewType)
    }
}