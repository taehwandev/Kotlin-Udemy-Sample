package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener
import tech.thdev.kotlin_udemy_sample.network.image.ImageDownloadAsync

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageAsyncViewHolder(
    parent: ViewGroup,
    private val onItemClickListener: OnItemClickListener?
) : BaseViewHolder<RecentPhotoItem>(R.layout.item_image_async_view, parent) {

    init {
        itemView.setOnClickListener {
            onItemClickListener?.onItemClick(adapterPosition)
        }
    }

    override fun bindView(item: RecentPhotoItem?) {
        // kotlin extensions 이용 view 사용
        itemView.tv_title.text = item?.title
        ImageDownloadAsync.loadImage(R.drawable.loading, itemView.image, item?.getImageUrl())
    }
}