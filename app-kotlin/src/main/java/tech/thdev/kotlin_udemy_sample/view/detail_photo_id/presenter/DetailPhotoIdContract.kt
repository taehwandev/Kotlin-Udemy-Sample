package tech.thdev.kotlin_udemy_sample.view.detail_photo_id.presenter

import com.example.base.presenter.BasePresenter
import com.example.base.presenter.BaseView
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by tae-hwan on 11/13/16.
 */

interface DetailPhotoIdContract {

    interface View : BaseView {

        fun updateItem(photo: FlickrPhoto)
    }

    interface Presenter : BasePresenter<View> {

        var photoDataSource: PhotoDataSource?

        fun loadPhotoInfo(photoInfo: String)
    }
}