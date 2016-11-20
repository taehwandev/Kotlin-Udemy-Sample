package tech.thdev.kotlin_udemy_sample.view.image.presenter

import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import java.util.*

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

        /**
         * PhotoId만 넘겨서 처리
         */
        fun showDetail(item: RecentPhotoItem)

        /**
         * Android Parcelable 예제
         */
        fun showDetailMore(item: ArrayList<RecentPhotoItem>, position: Int)

        /**
         * Extra string
         */
        fun  showExtraDetail(id: String)

        /**
         * Blur show
         */
        fun  showBlurView(item: RecentPhotoItem)

        /**
         * Blur hide
         */
        fun hideBlurView()
    }

    interface Presenter {

        var view: View?

        /**
         * Model
         */
        var photoDataSample: PhotoDataSource?

        var itemSelectType: Int

        /**
         * Adapter에 대한 View/Model을 정의한다
         */
        var adapterModel: ImageViewAdapterContract.Model?
        var adapterView: ImageViewAdapterContract.View?

        /**
         * Flickr image을 불러온다
         */
        fun getRecentImageSample(viewType: Int)

        fun destroy()
    }
}