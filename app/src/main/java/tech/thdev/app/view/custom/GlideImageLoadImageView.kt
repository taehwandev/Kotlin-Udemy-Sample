package tech.thdev.app.view.custom

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tech.thdev.app.R

/**
 * Created by taehwankwon on 05/11/2017.
 */
class GlideImageLoadImageView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : AppCompatImageView(context, attrs, defStyleAttr) {

    fun loadImage(url: String?, @DrawableRes loadingImageRes: Int = R.drawable.ic_bubble_chart_white_50dp) {
        Glide
                .with(this)
                .applyDefaultRequestOptions(RequestOptions.placeholderOf(loadingImageRes))
                .load(url)
                .into(this)
    }
}