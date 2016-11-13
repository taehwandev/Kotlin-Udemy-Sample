package tech.thdev.kotlin_udemy_sample.view.detail.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.base.presenter.AbstractPresenter
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by tae-hwan on 11/13/16.
 */

class DetailPresenter : AbstractPresenter<DetailContract.View>(), DetailContract.Presenter {

    override var photoDataSource: PhotoDataSource? = null

    override fun loadPhotoInfo(photoInfo: String) {
        photoDataSource?.getPhotoInfo(photoInfo)
                ?.enqueue(object : Callback<FlickrInfo> {

                    override fun onResponse(call: Call<FlickrInfo>?, response: Response<FlickrInfo>?) {
                        if (response?.isSuccessful ?: false) {
                            response?.body()?.let {
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