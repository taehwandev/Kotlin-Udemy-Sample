package tech.thdev.kotlin_udemy_sample.view.image.presenter

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoResponse
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener
import tech.thdev.kotlin_udemy_sample.view.image.adapter.ImageAdapter
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract

/**
 * Created by tae-hwan on 10/23/16.
 */

class ImagePresenter : ImageContract.Presenter {

    override var view: ImageContract.View? = null

    override var photoDataSample: PhotoDataSource? = null

    override var adapterModel: ImageViewAdapterContract.Model? = null
    override var adapterView: ImageViewAdapterContract.View? = null
        set(value) {
            field = value

            // Object을 이용한 onItemClickListener 정의
            field?.onItemClickListener = object : OnItemClickListener {

                override fun onItemClick(position: Int) {
                    adapterModel?.getItems()?.let {
                        view?.showDetailMore(it, position)
                    }
//                    adapterModel?.getItem(position)?.let {
//                        Log.d("TAG", "onItemClic")
//                    }
                }
            }
        }

    var page = 0
    var mViewType: Int = ImageAdapter.VIEW_TYPE_GLIDE

    override fun getRecentImageSample(viewType: Int) {
        if (mViewType != viewType) {
            page = 0
            adapterModel?.clear()
        }
        mViewType = viewType

        // object callback을 정의한다
        photoDataSample?.getRecentPhoto(++page)
                ?.enqueue(object : Callback<RecentPhotoResponse> {

                    override fun onResponse(call: Call<RecentPhotoResponse>?, response: Response<RecentPhotoResponse>?) {
                        if (response?.isSuccessful ?: false) {
//                            Log.d("TAG", "response raw " + response?.raw())

                            val photoResponse = response?.body()
                            if (photoResponse?.stat.equals("ok")) {
                                photoResponse?.photos?.photo?.forEachIndexed { i, photoItem ->
                                    photoItem.viewType = mViewType
                                    adapterModel?.addItem(photoItem)
                                }

                                Log.d("TAG", "reload>.... $adapterView")
                                // adapter의 reload
                                adapterView?.reload()

                                view?.showLoadSuccess()

                            } else {
                                view?.showLoadFailMessage("Code ${photoResponse?.code}, message ${photoResponse?.message}")
                            }

                        } else {
                            view?.showLoadFail()
                        }
                    }

                    override fun onFailure(call: Call<RecentPhotoResponse>?, t: Throwable?) {
                        view?.showLoadFail()
                    }
                })
    }
}