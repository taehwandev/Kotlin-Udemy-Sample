package tech.thdev.app.view.main.home.presenter

/**
 * Created by record-tae on 10/21/17.
 */
interface HomeContract {

    interface View {

        fun hideProgress()
        fun showProgress()
    }

    interface Presenter {

        fun loadImage()

        fun loadFlickrImage()
    }
}