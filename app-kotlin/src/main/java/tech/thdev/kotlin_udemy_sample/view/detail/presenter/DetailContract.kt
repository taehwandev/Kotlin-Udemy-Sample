package tech.thdev.kotlin_udemy_sample.view.detail.presenter

import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by tae-hwan on 11/13/16.
 */

interface DetailContract {

    interface View : BaseView {

        fun updateToolbarItem(buddyIcon: String, buddyName: String, imgUrl: String, imgTitle: String)

        fun updateItem(photo: FlickrPhoto)

        fun showShareUrl(photoPageUrl: String)

        fun showDetailPage(photoPageUrl: String)
    }

    interface Presenter : BasePresenter<View> {

        var photoDataSource: PhotoDataSource?

        fun loadPhotoInfo(photoInfo: String)

        fun shareUrl(type: Int)
    }
}