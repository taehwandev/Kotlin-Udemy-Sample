package tech.thdev.kotlin_udemy_sample.view.image.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.kotlin_udemy_sample.data.PhotoResponse
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract

/**
 * Created by tae-hwan on 10/23/16.
 */

class ImagePresenter : ImageContract.Presenter {

    override var view: ImageContract.View? = null

    override var photoDataSample: PhotoDataSource? = null

    override var adapterModel: ImageViewAdapterContract.Model? = null
    override var adapterView: ImageViewAdapterContract.View? = null

    var page = 0

    override fun getRecentImageSample() {
        // object callback을 정의한다
        photoDataSample?.getRecentPhoto(++page)
                ?.enqueue(object : Callback<PhotoResponse> {

                    override fun onResponse(call: Call<PhotoResponse>?, response: Response<PhotoResponse>?) {
                        if (response?.isSuccessful ?: false) {
//                            Log.d("TAG", "response raw " + response?.raw())

                            val photoResponse = response?.body()
                            if (photoResponse?.stat.equals("ok")) {
                                photoResponse?.photos?.photo?.forEach {
                                    // TODO adapter model 정의
                                    // adapterModel?.addItem(it)
                                }

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

                    override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                        view?.showLoadFail()
                    }
                })
    }
}