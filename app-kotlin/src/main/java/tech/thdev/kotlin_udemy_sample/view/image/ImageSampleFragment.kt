package tech.thdev.kotlin_udemy_sample.view.image

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.image.adapter.ImageAdapter
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageContract
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImagePresenter

/**
 * Created by tae-hwan on 10/3/16.
 */
class ImageSampleFragment : Fragment(), ImageContract.View {

    private val recyclerView by lazy {
        view?.findViewById<RecyclerView>(R.id.recycler_image)
    }

    private val fab by lazy {
        requireActivity().findViewById<FloatingActionButton>(R.id.fab)
    }

    // Java 식의 static instance
    companion object {
        fun getInstance() = ImageSampleFragment()
    }

    private var imageAdapter: ImageAdapter? = null

    private var presenter: ImageContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_image_sample, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ImagePresenter()
        presenter?.view = this

        imageAdapter = ImageAdapter(requireContext())

        /**
         * Model을 생성하여 셋팅한다
         */
        presenter?.photoDataSample = PhotoDataSource

        // TODO presenter에 Adapter model/View를 정의한다
        presenter?.adapterModel = imageAdapter
        presenter?.adapterView = imageAdapter


        recyclerView.adapter = imageAdapter
        // TODO kotlin extensions 으로 변경해보기
//        recycler_image.adapter = imageAdapter

        fab.setOnClickListener {
            presenter?.getRecentImageSample()
        }

        presenter?.getRecentImageSample()
    }

    override fun showLoadFailMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        Log.e("TAG", "Exception : " + message)
    }

    override fun showLoadSuccess() {
        Toast.makeText(context, "Load success", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadFail() {
        Toast.makeText(context, "Load fail", Toast.LENGTH_SHORT).show()
    }
}