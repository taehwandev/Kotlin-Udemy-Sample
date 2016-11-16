package tech.thdev.kotlin_udemy_sample.view.detail_more.adapter.model

import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem

/**
 * Created by tae-hwan on 11/17/16.
 */

interface SectionsPagerModel {

    var recentPhotoItemList: List<RecentPhotoItem>?

    fun getPhotoId(position: Int): String

    fun getPhotoUrl(position: Int): String
}