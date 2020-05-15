package tech.thdev.kotlin_udemy_sample.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.base.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail_more.*
import tech.thdev.kotlin_udemy_sample.R

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class DetailMoreFragment(
    private val imageUrl: String
) : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_detail_more, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        img_large_view.setOnClickListener {
            // view visible/gone
        }

        img_large_view?.let {
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .into(img_large_view)
        }
    }
}