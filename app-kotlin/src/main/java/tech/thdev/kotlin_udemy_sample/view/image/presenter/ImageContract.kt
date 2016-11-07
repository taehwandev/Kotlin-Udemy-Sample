package tech.thdev.kotlin_udemy_sample.view.image.presenter

import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by tae-hwan on 10/23/16.
 */

interface ImageContract {

    interface View {

        /**
         * 로딩 완료
         */
        fun showLoadSuccess()

        /**
         * 로딩 실패
         */
        fun showLoadFail()

        fun showLoadFailMessage(message: String)
    }

    interface Presenter {

        var view: View?

        /**
         * Model
         */
        var photoDataSample: PhotoDataSource?

        /**
         * Flickr image을 불러온다
         */
        fun getRecentImageSample()
    }
}