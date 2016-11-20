package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.listener.OnItemTouchListener

/**
 * Created by tae-hwan on 10/29/16.
 */

class ImageGlideViewHolder(context: Context, parent: ViewGroup?,
                           val onItemTouchListener: OnItemTouchListener?) :
        BaseViewHolder<RecentPhotoItem>(R.layout.item_image_view, context, parent) {

    override fun bindView(item: RecentPhotoItem?, position: Int) {
        itemView?.let {
            // kotlin extensions 이용 view 사용
            with(it) {
                Log.d("TAG", "item ${item?.title}")
                tv_title.text = item?.title
                Glide.with(context)
                        .load(item?.getImageUrl())
                        .centerCrop()
                        .placeholder(R.drawable.loading)
                        .into(image)
            }

            it.setOnTouchListener { view, motionEvent ->
                onItemTouchListener?.onItemTouch(motionEvent, position) ?: false
            }
        }
    }
}