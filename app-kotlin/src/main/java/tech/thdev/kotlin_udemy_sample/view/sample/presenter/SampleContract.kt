package tech.thdev.kotlin_udemy_sample.view.sample.presenter

import tech.thdev.kotlin_udemy_sample.adapter.sample_one.model.SampleOneModel
import tech.thdev.kotlin_udemy_sample.adapter.sample_two.model.SampleTwoModel

/**
 * Created by tae-hwan on 10/23/16.
 */

interface SampleContract {

    interface View {

        /**
         * RecyclerView One을 갱신한다
         */
        fun adapterOneNotify()

        fun onSuccessAddItem(position: Int)

        /**
         * RecyclerView Two를 갱신한다
         */
        fun adapterTwoNotify()

        fun onSuccessRemoveItem()
    }

    interface Presenter {

        var view: View?

        /**
         * Adapter one의 model
         */
        var sampleOneModel: SampleOneModel?

        /**
         * Adapter two의 model
         */
        var sampleTwoModel: SampleTwoModel?

        /**
         * 첫 번째 RecyclerView에 값을 정의
         */
        fun loadDefaultItems()

        /**
         * Sample에 item을 하나씩 추가한다
         */
        fun adapterOneAddItem()

        /**
         * Adapter One에 클릭을 처리한다
         */
        fun adapterOneItemClick(position: Int)

        /**
         * Adapter Two의 아이템을 삭제한다
         */
        fun adapterTwoRemoveItem()

        /**
         * Adapter Two의 아이템을 클릭한다
         */
        fun adapterTwoItemClick(position: Int)
    }
}