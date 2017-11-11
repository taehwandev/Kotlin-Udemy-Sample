package tech.thdev.app.view.main.home.presenter

/**
 * Created by record-tae on 10/21/17.
 */
interface HomeContract {

    interface View {

        fun hideProgress()
        fun showProgress()

        fun showLoadFail()
        fun showLoadFail(message: String)
    }

    interface Presenter {

        fun loadFlickrImage()
    }
}