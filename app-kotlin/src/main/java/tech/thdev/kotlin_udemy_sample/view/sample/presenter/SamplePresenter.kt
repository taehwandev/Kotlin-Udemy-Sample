package tech.thdev.kotlin_udemy_sample.view.sample.presenter

import tech.thdev.kotlin_udemy_sample.adapter.model.SampleOneModel
import tech.thdev.kotlin_udemy_sample.adapter.model.SampleTwoModel
import tech.thdev.kotlin_udemy_sample.data.SampleItem

/**
 * Created by tae-hwan on 10/23/16.
 */

class SamplePresenter : SampleContract.Presenter {

    override var view: SampleContract.View? = null

    override var sampleOneModel: SampleOneModel? = null

    override var sampleTwoModel: SampleTwoModel? = null

    private var count = 0

    override fun loadDefaultItems() {
        for (position in 0..5) {
            sampleOneModel?.addItem(SampleItem("Item ${++count}"))
        }

        view?.adapterOneNotify()
    }

    override fun adapterOneAddItem() {
        sampleOneModel?.addItem(SampleItem("Item ${++count}"))
        view?.onSuccessAddItem()
        view?.adapterOneNotify()
    }

    override fun adapterOneItemClick(position: Int) {
        sampleOneModel?.getItem(position)?.let {
            sampleTwoModel?.addItem(it)
            sampleOneModel?.removeItem(it)

            view?.adapterOneNotify()
            view?.adapterTwoNotify()
        }
    }

    override fun adapterTwoRemoveItem() {
        val selectItem = sampleTwoModel?.getSelectItem()
        selectItem?.let {
            it.iterator().forEach {

                // TODO 오류 해결
                sampleTwoModel?.getItem(it)?.let {
                    sampleTwoModel?.removeItem(it)
                    sampleOneModel?.addItem(it)
                }
            }

            view?.adapterOneNotify()
            view?.adapterTwoNotify()
            view?.onSuccessRemoveItem()
        }
    }

    override fun adapterTwoItemClick(position: Int) {
        sampleTwoModel?.getItem(position)?.let {
            val selectItem = sampleTwoModel?.getSelectItem()
            if (selectItem?.contains(position) ?: false) {
                selectItem?.remove(position)
                it.isSelected = false

            } else {
                selectItem?.add(position)
                it.isSelected = true
            }

            view?.adapterTwoNotify()
        }
    }
}