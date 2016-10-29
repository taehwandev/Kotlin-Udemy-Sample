package tech.thdev.kotlin_udemy_sample.data.model

import android.content.Context
import tech.thdev.kotlin_udemy_sample.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageSampleData {

    fun getImageDatas(context: Context, size: Int): ArrayList<ImageItem> {
        val list = ArrayList<ImageItem>()
        for (index in 0..size) {
            val name = String.format("sample_%02d", (Math.random() * 6).toInt())
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource))
        }
        return list
    }
}