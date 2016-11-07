package tech.thdev.kotlin_udemy_sample.view.image.presenter

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.kotlin_udemy_sample.data.PhotoResponse
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

/**
 * Created by tae-hwan on 10/23/16.
 */

class ImagePresenter : ImageContract.Presenter {

    override var view: ImageContract.View? = null

    override var photoDataSample: PhotoDataSource? = null

    var page = -1

    override fun getRecentImageSample() {
        // object callback을 정의한다
        photoDataSample?.getRecentPhoto(page)
                ?.enqueue(object : Callback<PhotoResponse> {

                    override fun onResponse(call: Call<PhotoResponse>?, response: Response<PhotoResponse>?) {
                        response?.isSuccessful.apply {
                            val photoResponse = response?.body()
                            if (photoResponse?.code == 200) {
                                Log.d("TAG", "response raw " + response?.raw())
                                view?.showLoadSuccess()

                            } else {
                                view?.showLoadFailMessage("Code ${photoResponse?.code}, message ${photoResponse?.message}")
                            }

                        } ?: view?.showLoadFail()
                    }

                    override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                        view?.showLoadFail()
                    }
                })
    }
}