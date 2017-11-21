package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.content.Context
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemTouchListener
import tech.thdev.kotlin_udemy_sample.network.image.ImageDownloadAsync

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageAsyncViewHolder(context: Context, parent: ViewGroup?,
                           val onItemTouchListener: OnItemTouchListener?) :
        BaseViewHolder<RecentPhotoItem>(R.layout.item_image_async_view, context, parent) {

    override fun bindView(item: RecentPhotoItem?, position: Int) {
        itemView?.let {
            // kotlin extensions 이용 view 사용
            with(it) {
                ImageDownloadAsync.loadImage(R.drawable.loading, image, item?.getImageUrl())
            }

            it.setOnTouchListener { view, motionEvent ->
                onItemTouchListener?.onItemTouch(motionEvent, position) ?: false
            }
        }
    }
}