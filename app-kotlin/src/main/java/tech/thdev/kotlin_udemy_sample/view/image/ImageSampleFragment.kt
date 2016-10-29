package tech.thdev.kotlin_udemy_sample.view.image

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.adapter.ImageSampleAdapter
import tech.thdev.kotlin_udemy_sample.data.ImageItem
import tech.thdev.kotlin_udemy_sample.data.model.ImageSampleData
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageSampleContract
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageSamplePresenter

/**
 * Created by tae-hwan on 10/3/16.
 */
class ImageSampleFragment : Fragment(), ImageSampleContract.View {

    private val recyclerView by lazy {
        view?.findViewById(R.id.recycler_view) as RecyclerView
    }

    private val fab by lazy {
        activity.findViewById(R.id.fab) as FloatingActionButton
    }

    // Java 식의 static instance
    companion object {
        fun getInstance() = ImageSampleFragment()
    }

    private var imageSampleAdapter: ImageSampleAdapter? = null

    private var image: ImageSampleContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_image_sample, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = ImageSamplePresenter()
        image?.view = this

        /**
         * Model을 생성하여 셋팅한다
         */
        image?.imageSampleData = ImageSampleData()

        imageSampleAdapter = ImageSampleAdapter(context)
        recyclerView.adapter = imageSampleAdapter

        fab.setOnClickListener {
            image?.updateImageSample(context)
        }

        image?.updateImageSample(context)
    }

    override fun addItem(it: ImageItem) {
        imageSampleAdapter?.addItem(it)
    }

    override fun adapterNotify() {
        imageSampleAdapter?.notifyDataSetChanged()
    }
}