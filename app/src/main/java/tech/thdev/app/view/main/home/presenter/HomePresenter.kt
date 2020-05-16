package tech.thdev.app.view.main.home.presenter

import android.os.AsyncTask
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.app.data.PhotoResponse
import tech.thdev.app.data.source.flickr.FlickrRepository
import tech.thdev.app.data.source.image.ImageRepository
import tech.thdev.app.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by record-tae on 10/21/17.
 */
class HomePresenter(
    private val view: HomeContract.View,
    private val flickrRepository: FlickrRepository,
    private val imageRepository: ImageRepository,
    private val imageRecyclerModel: ImageRecyclerModel
) : HomeContract.Presenter {

    var isLoading = false

    private val perPage = 50
    private var page = 0

    override fun loadFlickrImage() {
        flickrRepository.getRecentPhoto(++page, perPage)
            .enqueue(object : Callback<PhotoResponse> {
                override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                    // 불러오기 실패할 경우
                }

                override fun onResponse(
                    call: Call<PhotoResponse>?,
                    response: Response<PhotoResponse>?
                ) {
                    // 불러오기 성공할 경우
                }
            })
    }

    override fun loadImage() {
        ImageAsyncTask(this, view, imageRepository, imageRecyclerModel).execute()
    }

    class ImageAsyncTask(
        private val homePresenter: HomePresenter,
        private val view: HomeContract.View,
        private val imageRepository: ImageRepository,
        private val imageRecyclerModel: ImageRecyclerModel
    ) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg params: Unit?) {
            imageRepository.loadImageList({
                it.forEach {
                    imageRecyclerModel.addItem(it)
                }
            }, 10)
        }

        override fun onPreExecute() {
            super.onPreExecute()

            homePresenter.isLoading = true
            view.showProgress()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            imageRecyclerModel.notifyDataSetChang()
            view.hideProgress()

            homePresenter.isLoading = false
        }
    }
}