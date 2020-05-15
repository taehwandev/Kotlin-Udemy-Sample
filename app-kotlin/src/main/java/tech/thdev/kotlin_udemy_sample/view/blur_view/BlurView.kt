package tech.thdev.kotlin_udemy_sample.view.blur_view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlinx.android.synthetic.main.view_blur.view.*
import tech.thdev.kotlin_udemy_sample.R

/**
 * Created by tae-hwan on 11/20/16.
 */

class BlurView : CoordinatorLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        initView()
    }

    private fun initView() {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.view_blur, this, false)
        addView(view)
    }

    /**
     * Background setting
     */
    fun setImageView(bitmap: Bitmap) {
        blur_background.background = BitmapDrawable(bitmap)
    }

    fun getImageView() = with(rootView) {
        img_blur_over_view
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        rl_blur_container.visibility = visibility
        rl_item_view.visibility = visibility
        img_blur_over_view.visibility = visibility
        tv_title.visibility = visibility
    }

    fun setTitle(title: String) {
        tv_title.text = title
    }
}
