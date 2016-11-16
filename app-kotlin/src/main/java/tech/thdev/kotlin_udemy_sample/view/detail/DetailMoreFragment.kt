package tech.thdev.kotlin_udemy_sample.view.detail

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail_more.*
import tech.thdev.base.view.BaseFragment
import tech.thdev.kotlin_udemy_sample.R

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class DetailMoreFragment(val imageUrl: String) : BaseFragment() {

    override fun getLayout() = R.layout.fragment_detail_more

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        img_large_view.setOnClickListener {
            // view visible/gone
        }

        img_large_view?.let {
            Glide.with(this)
                    .load(imageUrl)
                    .fitCenter()
                    .crossFade()
                    .into(img_large_view)
        }
    }
}