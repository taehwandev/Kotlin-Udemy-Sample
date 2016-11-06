package tech.thdev.kotlin_udemy_sample.view.sample.presenter

import tech.thdev.kotlin_udemy_sample.adapter.sample_one.SampleOneAdapter
import tech.thdev.kotlin_udemy_sample.adapter.sample_one.model.SampleOneModel
import tech.thdev.kotlin_udemy_sample.adapter.sample_two.model.SampleTwoModel
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
            sampleOneModel?.addItem(SampleItem("Item ${++count}", SampleOneAdapter.VIEW_TYPE_TEXT))
        }

        view?.adapterOneNotify()
    }

    override fun adapterOneAddItem() {
        sampleOneModel?.addItem(SampleItem("Item ${++count}", SampleOneAdapter.VIEW_TYPE_TEXT))
        view?.onSuccessAddItem(sampleOneModel?.getItemCount()?.let { it - 1 } ?: 0)
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

    /**
     * Adapter Two의 선택 목록을 불러오고
     */
    override fun adapterTwoRemoveItem() {
        sampleTwoModel?.
                getItems()?.
                filter { it.isSelected }?.
                map {
                    it.isSelected = false
                    sampleOneModel?.addItem(it)
                    sampleTwoModel?.removeItem(it)
                }

        view?.adapterOneNotify()
        view?.adapterTwoNotify()
        view?.onSuccessRemoveItem()
    }

    override fun adapterTwoItemClick(position: Int) {
        sampleTwoModel?.getItem(position)?.let {
            it.isSelected = !it.isSelected

            view?.adapterTwoNotify()
        }
    }

    override fun addSampleImageItem() {
        sampleOneModel?.addItem(SampleItem("", SampleOneAdapter.VIEW_TYPE_IMAGE))
        view?.onSuccessImageSample(sampleOneModel?.getItemCount()?.let { it - 1 } ?: 0)
        view?.adapterOneNotify()
    }
}