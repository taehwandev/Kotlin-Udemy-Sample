package tech.thdev.kotlin_udemy_sample.view.image.adapter.model

import android.view.MotionEvent
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemTouchListener
import java.util.*

/**
 * Created by tae-hwan on 11/13/16.
 */

interface ImageViewAdapterContract {

    interface View {

        /**
         * ItemTouch event
         */
        val onItemTouchListener: OnItemTouchListener?

        fun setOnItemTouchListener(onTouch: (MotionEvent?, Int) -> Boolean)

        fun reload()
    }

    /**
     * Adapter에서 사용할 Model에 대한 interface 정의
     */
    interface Model {

        fun addItem(item: RecentPhotoItem?)

        fun getItems(): ArrayList<RecentPhotoItem>

        fun getItem(position: Int): RecentPhotoItem

        /**
         * Item clear 추가
         */
        fun clear()
    }
}