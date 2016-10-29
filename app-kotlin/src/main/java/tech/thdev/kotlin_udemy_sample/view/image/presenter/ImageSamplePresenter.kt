package tech.thdev.kotlin_udemy_sample.view.image.presenter

import android.content.Context
import android.util.Log
import tech.thdev.kotlin_udemy_sample.data.model.ImageSampleData

/**
 * Created by tae-hwan on 10/23/16.
 */

class ImageSamplePresenter : ImageSampleContract.Presenter {

    override var view: ImageSampleContract.View? = null

    override var imageSampleData: ImageSampleData? = null

    override fun updateImageSample(context: Context) {
        // Model로 부터 Image load
        imageSampleData?.getImageDatas(context, 6)?.forEach {
            Log.e("TAG", "$it??")
            view?.addItem(it)
        }
        // View를 다시 갱신
        view?.adapterNotify()
    }

//    override fun getItems(size: Int) {
//        if (size < 50) {
//            val tempSize = size + 1
//            val tempCount = (size / 10) + 1
//
//            for (index in tempSize..(10 * tempCount)) {
//                view?.addItem(index)
//            }
//
//            view?.adapterNotify()
//        }
//    }
}