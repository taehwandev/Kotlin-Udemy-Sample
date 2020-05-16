package tech.thdev.app.view.main.home.presenter

import android.os.AsyncTask
import tech.thdev.app.data.source.image.ImageRepository

/**
 * Created by record-tae on 10/21/17.
 */
class HomePresenter(
    private val view: HomeContract.View,
    private val imageRepository: ImageRepository
) : HomeContract.Presenter {

    override fun loadImage() {
        ImageAsyncTask(view, imageRepository).execute()
    }

    class ImageAsyncTask(
        private val view: HomeContract.View,
        private val imageRepository: ImageRepository
    ) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg params: Unit?) {
            Thread.sleep(1000)
        }

        override fun onPreExecute() {
            super.onPreExecute()

            view.showProgress()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            view.hideProgress()

            imageRepository.loadImageFileName {
                view.showImage(it)
            }
        }
    }
}