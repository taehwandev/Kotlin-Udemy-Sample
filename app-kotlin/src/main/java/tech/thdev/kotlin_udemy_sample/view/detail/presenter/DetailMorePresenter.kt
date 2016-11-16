package tech.thdev.kotlin_udemy_sample.view.detail.presenter

import android.content.Intent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.base.presenter.AbstractPresenter
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.detail.adapter.model.SectionsPagerModel

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class DetailMorePresenter : AbstractPresenter<DetailMoreContract.View>(), DetailMoreContract.Presenter {

    override var photoDataSource: PhotoDataSource? = null

    override var flickrInfo: FlickrInfo? = null

    override var pagerModel: SectionsPagerModel? = null

    override fun setRecentItemList(intent: Intent) {
        pagerModel?.recentPhotoItemList = intent.getParcelableArrayListExtra(Constant.KEY_PHOTO_DATA)
    }

    override fun loadPhotoInfo(position: Int) {
        pagerModel?.getPhotoId(position)?.let {
            photoDataSource?.getPhotoInfo(it)
                    ?.enqueue(object : Callback<FlickrInfo> {

                        override fun onResponse(call: Call<FlickrInfo>?, response: Response<FlickrInfo>?) {
                            if (response?.isSuccessful ?: false) {
                                response?.body()?.let {
                                    flickrInfo = it
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
    }

    override fun getPhotoDetailUrl(type: Int) {
        flickrInfo?.let {
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