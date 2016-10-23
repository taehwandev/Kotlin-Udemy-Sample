package tech.thdev.kotlin_udemy_sample.view.sample.presenter

/**
 * Created by tae-hwan on 10/23/16.
 */

class PresenterSamplePresenter : PresenterSampleContract.Presenter {

    override var view: PresenterSampleContract.View? = null

    override fun getItems(size: Int) {
        if (size < 50) {
            val tempSize = size + 1
            val tempCount = (size / 10) + 1

            for (index in tempSize..(10 * tempCount)) {
                view?.addItem(index)
            }

            view?.adapterNotify()
        }
    }
}