package tech.thdev.kotlin_udemy_sample.view.detail_more.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.view.detail_more.DetailMoreFragment
import tech.thdev.kotlin_udemy_sample.view.detail_more.adapter.model.SectionsPagerModel

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class SectionsPagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager), SectionsPagerModel {

    override var recentPhotoItemList: List<RecentPhotoItem>? = null

    override fun getItem(position: Int): Fragment {
        return DetailMoreFragment(getPhotoUrl(position))
    }

    override fun getCount() = recentPhotoItemList?.size ?: 0

    override fun getPhotoId(position: Int) = recentPhotoItemList?.getOrNull(position)?.id ?: ""

    override fun getPhotoUrl(position: Int) = recentPhotoItemList?.getOrNull(position)?.getImageUrl() ?: ""
}