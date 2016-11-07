package tech.thdev.kotlin_udemy_sample.data

/**
 * Created by tae-hwan on 11/7/16.
 */

data class PhotoResponse(
        val photos: PhotoPageInfo,
        val stat: String,
        val code: Int,
        val message: String)