package tech.thdev.kotlin_udemy_sample.data

/**
 * Created by tae-hwan on 11/13/16.
 */

data class FlickrOwner(val nsid: String,
                       val username: String,
                       val realname: String,
                       val location: String,
                       val iconserver: String,
                       val iconfarm: Int,
                       val path_alias: String) {

    /**
     * Buddyicons API : <a href="https://www.flickr.com/services/api/misc.buddyicons.html">api</a>
     * http://farm{icon-farm}.staticflickr.com/{icon-server}/buddyicons/{nsid}.jpg
     */
    fun getBuddyIcons()
        = "http://farm$iconfarm.staticflickr.com/$iconserver/buddyicons/$nsid.jpg"
}