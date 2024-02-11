package tech.thdev.kotlin_udemy_sample.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.base.ui.BaseFragment
import tech.thdev.kotlin_udemy_sample.databinding.FragmentDetailMoreBinding

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class DetailMoreFragment(
    private val imageUrl: String
) : BaseFragment() {

    private lateinit var fragmentDetailMoreBinding: FragmentDetailMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentDetailMoreBinding.inflate(inflater, container, false).also {
            fragmentDetailMoreBinding = it
        }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentDetailMoreBinding.imgLargeView.setOnClickListener {
            // view visible/gone
        }

        fragmentDetailMoreBinding.imgLargeView.let {
            Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .into(it)
        }
    }
}