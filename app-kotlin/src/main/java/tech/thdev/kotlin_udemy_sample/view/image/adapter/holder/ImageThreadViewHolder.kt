package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.content.Context
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.PhotoItem
import tech.thdev.kotlin_udemy_sample.network.image.ImageDownloadThread

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageThreadViewHolder(context: Context, parent: ViewGroup?) :
        BaseViewHolder<PhotoItem>(R.layout.item_image_thread_view, context, parent) {

    override fun bindView(item: PhotoItem?, position: Int) {
        itemView?.let {
            // kotlin extensions 이용 view 사용
            with(it) {
                tv_title.text = item?.title
                ImageDownloadThread.loadImage(R.drawable.loading, image, item?.getImageUrl())
            }
        }
    }
}