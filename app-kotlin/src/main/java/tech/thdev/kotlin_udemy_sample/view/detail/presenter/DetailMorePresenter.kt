package tech.thdev.kotlin_udemy_sample.view.detail.presenter

import android.content.Intent
import com.example.base.presenter.CommonPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrInfo
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.detail.adapter.model.SectionsPagerModel

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class DetailMorePresenter : CommonPresenter<DetailMoreContract.View>(), DetailMoreContract.Presenter {

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
                                }
                                view?.updateToolbarItem(flickrInfo?.photo?.owner?.getBuddyIcons() ?: "",
                                        flickrInfo?.photo?.owner?.username ?: "",
                                        flickrInfo?.photo?.getImageUrl() ?: "",
                                        flickrInfo?.photo?.title?._content ?: "")
                                flickrInfo?.photo?.let {
                                    view?.updateItem(it)
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