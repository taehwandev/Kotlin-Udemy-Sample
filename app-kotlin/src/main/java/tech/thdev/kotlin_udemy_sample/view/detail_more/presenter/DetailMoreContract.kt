package tech.thdev.kotlin_udemy_sample.view.detail_more.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

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

        fun loadPhotoInfo(photoInfo: String)

        fun getPhotoDetailUrl(type: Int)
    }
}