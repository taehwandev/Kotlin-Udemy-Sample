package tech.thdev.kotlin_udemy_sample.view.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.adapter.ImageSampleAdapter
import tech.thdev.kotlin_udemy_sample.data.ImageItem
import tech.thdev.kotlin_udemy_sample.data.model.ImageSampleData
import tech.thdev.kotlin_udemy_sample.databinding.FragmentImageSampleBinding
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageSampleContract
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageSamplePresenter

/**
 * Created by tae-hwan on 10/3/16.
 */
class ImageSampleFragment : Fragment(), ImageSampleContract.View {

    private val fab by lazy {
        requireActivity().findViewById<FloatingActionButton>(R.id.fab)
    }

    private lateinit var fragmentImageSampleBinding: FragmentImageSampleBinding

    // Java 식의 static instance
    companion object {
        fun getInstance() = ImageSampleFragment()
    }

    private var imageSampleAdapter: ImageSampleAdapter? = null

    private var image: ImageSampleContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentImageSampleBinding.inflate(layoutInflater, container, false).also {
            fragmentImageSampleBinding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = ImageSamplePresenter()
        image?.view = this

        /**
         * Model을 생성하여 셋팅한다
         */
        image?.imageSampleData = ImageSampleData()

        imageSampleAdapter = ImageSampleAdapter(requireContext())
        fragmentImageSampleBinding.recyclerView.adapter = imageSampleAdapter

        fab.setOnClickListener {
            image?.updateImageSample(requireContext())
        }

        image?.updateImageSample(requireContext())
    }

    override fun addItem(it: ImageItem) {
        imageSampleAdapter?.addItem(it)
    }

    override fun adapterNotify() {
        imageSampleAdapter?.notifyDataSetChanged()
    }
}