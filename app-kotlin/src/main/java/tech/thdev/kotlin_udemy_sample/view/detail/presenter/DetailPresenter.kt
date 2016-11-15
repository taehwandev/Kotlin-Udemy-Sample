package tech.thdev.kotlin_udemy_sample.view.detail.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.base.presenter.AbstractPresenter
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by tae-hwan on 11/13/16.
 */

class DetailPresenter : AbstractPresenter<DetailContract.View>(), DetailContract.Presenter {

    override var photoDataSource: PhotoDataSource? = null

    private var backItem: FlickrPhoto? = null

    override fun loadPhotoInfo(photoInfo: String) {
        photoDataSource?.getPhotoInfo(photoInfo)
                ?.enqueue(object : Callback<FlickrInfo> {

                    override fun onResponse(call: Call<FlickrInfo>?, response: Response<FlickrInfo>?) {
                        if (response?.isSuccessful ?: false) {
                            response?.body()?.let {
                                backItem = it.photo
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

    override fun shareUrl(type: Int) {
        backItem?.let {
            it.urls.url.first {
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