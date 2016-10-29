package tech.thdev.kotlin_udemy_sample.view.image.presenter

import android.content.Context
import tech.thdev.kotlin_udemy_sample.data.ImageItem
import tech.thdev.kotlin_udemy_sample.data.model.ImageSampleData

/**
 * Created by tae-hwan on 10/23/16.
 */

interface ImageSampleContract {

    interface View {
        /**
         * RecyclerView에 아이템을 추가한다
         */
        fun addItem(it: ImageItem)

        /**
         * RecyclerView를 갱신한다
         */
        fun adapterNotify()
    }

    interface Presenter {

        var view: View?

        /**
         * Model
         */
        var imageSampleData: ImageSampleData?

        /**
         * RecyclerView에 사용될 아이템을 가져온다
         */
        fun updateImageSample(context: Context)
    }
}