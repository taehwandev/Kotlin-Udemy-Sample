package tech.thdev.kotlin_udemy_sample.view.detail_more.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.view.detail_more.DetailMoreFragment

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class SectionsPagerAdapter(fragmentManager: FragmentManager,
                           val itemList: List<RecentPhotoItem>?) :
        FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return DetailMoreFragment.create(getPhotoItem(position))
    }

    private fun getPhotoItem(position: Int) = itemList?.getOrNull(position)?.id

    override fun getCount() = itemList?.size ?: 0
}