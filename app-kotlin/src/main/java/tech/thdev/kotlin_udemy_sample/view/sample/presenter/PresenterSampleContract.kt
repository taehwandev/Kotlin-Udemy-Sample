package tech.thdev.kotlin_udemy_sample.view.sample.presenter

/**
 * Created by tae-hwan on 10/23/16.
 */

interface PresenterSampleContract {

    interface View {
        /**
         * RecyclerView에 아이템을 추가한다
         */
        fun addItem(index: Int)

        /**
         * RecyclerView를 갱신한다
         */
        fun adapterNotify()
    }

    interface Presenter {

        var view: View?

        /**
         * RecyclerView에 사용될 아이템을 가져온다
         */
        fun getItems(size: Int)
    }
}