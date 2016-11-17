package tech.thdev.kotlin_udemy_sample.view.detail_photo_id.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.base.presenter.AbstractPresenter
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by tae-hwan on 11/13/16.
 */

class DetailPhotoIdPresenter : AbstractPresenter<DetailPhotoIdContract.View>(), DetailPhotoIdContract.Presenter {

    override var photoDataSource: PhotoDataSource? = null

    private var backItem: FlickrPhoto? = null

    override fun loadPhotoInfo(photoInfo: String) {
        photoDataSource?.getPhotoInfo(photoInfo)
                ?.enqueue(object : Callback<FlickrInfo> {

                    override fun onResponse(call: Call<FlickrInfo>?, response: Response<FlickrInfo>?) {
                        if (response?.isSuccessful ?: false) {
                            response?.body()?.let {
                                backItem = it.photo
                                view?.updateItem(it.photo)
                            }
                        }
                    }

                    override fun onFailure(call: Call<FlickrInfo>?, t: Throwable?) {
                        // fail
                    }
                })
    }
}