package tech.thdev.kotlin_udemy_sample.view.detail_more.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.base.presenter.AbstractPresenter
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class DetailMorePresenter : AbstractPresenter<DetailMoreContract.View>(), DetailMoreContract.Presenter {

    override var photoDataSource: PhotoDataSource? = null

    private var backItem: FlickrInfo? = null

    override fun loadPhotoInfo(photoInfo: String) {
        photoDataSource?.getPhotoInfo(photoInfo)
                ?.enqueue(object : Callback<FlickrInfo> {

                    override fun onResponse(call: Call<FlickrInfo>?, response: Response<FlickrInfo>?) {
                        if (response?.isSuccessful ?: false) {
                            response?.body()?.let {
                                backItem = it
                                view?.updateToolbarItem(it.photo.owner.getBuddyIcons(), it.photo.owner.username, it.photo.getImageUrl(), it.photo.title._content)
                                view?.updateItem(it.photo)
                            }
                        }
                    }

                    override fun onFailure(call: Call<FlickrInfo>?, t: Throwable?) {
                        // fail
                    }
                })
    }

    override fun getPhotoDetailUrl(type: Int) {
        backItem?.let {
            it.photo.urls.url.first {
                when (type) {
                    Constant.TYPE_DETAIL_PAGE -> {
                        view?.showDetailPage(it._content)
                    }
                    Constant.TYPE_SHARE_URL -> {
                        view?.showShareUrl(it._content)
                    }
                }
                true
            }
        }
    }
}