package tech.thdev.kotlin_udemy_sample.view.detail.presenter

import android.content.Intent
import com.example.base.presenter.BasePresenter
import com.example.base.presenter.BaseView
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.detail.adapter.model.SectionsPagerModel

/**
 * Created by Tae-hwan on 16/11/2016.
 */

interface DetailMoreContract {

    interface View : BaseView {

        fun updateToolbarItem(buddyIcon: String, buddyName: String, imgUrl: String, imgTitle: String)

        fun updateItem(photo: FlickrPhoto)

        fun showShareUrl(photoPageUrl: String)

        fun showDetailPage(photoPageUrl: String)
    }

    interface Presenter : BasePresenter<View> {

        var photoDataSource: PhotoDataSource?

        var pagerModel: SectionsPagerModel?

        var flickrInfo: FlickrInfo?

        fun setRecentItemList(intent: Intent)

        fun loadPhotoInfo(position: Int)

        fun getPhotoDetailUrl(type: Int)
    }
}