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

        fun updateItem(photo: FlickrPhoto)
    }

    interface Presenter : BasePresenter<View> {

        var photoDataSource: PhotoDataSource?

        fun loadPhotoInfo(photoInfo: String)
    }
}