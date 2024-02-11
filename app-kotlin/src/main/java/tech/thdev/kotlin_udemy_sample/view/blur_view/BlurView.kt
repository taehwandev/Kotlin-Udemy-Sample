package tech.thdev.kotlin_udemy_sample.view.blur_view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import tech.thdev.kotlin_udemy_sample.databinding.ViewBlurBinding

/**
 * Created by tae-hwan on 11/20/16.
 */

class BlurView : CoordinatorLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        initView()
    }

    private lateinit var viewBlurBinding: ViewBlurBinding

    private fun initView() {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        viewBlurBinding = ViewBlurBinding.inflate(layoutInflater)
        addView(viewBlurBinding.root)
    }

    /**
     * Background setting
     */
    fun setImageView(bitmap: Bitmap) {
        viewBlurBinding.blurBackground.background = BitmapDrawable(bitmap)
    }

    fun getImageView() =
        viewBlurBinding.imgBlurOverView

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        viewBlurBinding.rlBlurContainer.visibility = visibility
        viewBlurBinding.rlItemView.visibility = visibility
        viewBlurBinding.imgBlurOverView.visibility = visibility
        viewBlurBinding.tvTitle.visibility = visibility
    }

    fun setTitle(title: String) {
        viewBlurBinding.tvTitle.text = title
    }
}
