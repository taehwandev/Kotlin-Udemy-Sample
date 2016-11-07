package tech.thdev.kotlin_udemy_sample.data

/**
 * Created by tae-hwan on 11/7/16.
 */

data class PhotoPageInfo(val page: Int,
                         val pages: Int,
                         val perpage: Int,
                         val total: Int,
                         val photo: List<PhotoItem>,
                         val stat: String)