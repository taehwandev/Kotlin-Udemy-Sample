package tech.thdev.kotlin_udemy_sample.view.image.adapter.model

import tech.thdev.kotlin_udemy_sample.data.PhotoItem

/**
 * Created by tae-hwan on 11/13/16.
 */

interface ImageViewAdapterContract {

    interface View {
        fun reload()
    }

    /**
     * Adapter에서 사용할 Model에 대한 interface 정의
     */
    interface Model {
        fun addItem(item: PhotoItem)

        /**
         * Item clear 추가
         */
        fun clear()
    }
}