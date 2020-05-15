package tech.thdev.kotlin_udemy_sample.view.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.view.sample.presenter.PresenterSampleContract
import tech.thdev.kotlin_udemy_sample.view.sample.presenter.PresenterSamplePresenter

/**
 * Created by tae-hwan on 10/3/16.
 */
class PresenterSampleFragment : Fragment(), PresenterSampleContract.View {

    private val recyclerView by lazy {
        view?.findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val fab by lazy {
        requireActivity().findViewById<FloatingActionButton>(R.id.fab)
    }

    // Java 식의 static instance
    companion object {
        fun getInstance() = PresenterSampleFragment()
    }

    private var sampleAdapter: PresenterSampleAdapter? = null

    private var presenter: PresenterSampleContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = PresenterSamplePresenter()
        presenter?.view = this

        sampleAdapter = PresenterSampleAdapter(requireContext())
        recyclerView?.adapter = sampleAdapter

//        sampleAdapter?.let {
//            addItems(0)
//            sampleAdapter?.notifyDataSetChanged()
//        }
        presenter?.getItems(0)

        fab.setOnClickListener {
            // item을 50개보다 작은 동안 추가한다
//            sampleAdapter?.let {
//                if (it.itemCount < 50) {
//                    addItems(it.itemCount)
//                    sampleAdapter?.notifyDataSetChanged()
//                }
//            }
            presenter?.getItems(sampleAdapter?.itemCount ?: 0)
        }
    }

//    private fun addItems(size: Int) {
//        val tempSize = size + 1
//        val tempCount = (size / 10) + 1
//        for (index in tempSize..(10 * tempCount)) {
//            sampleAdapter?.addItem(index)
//        }
//    }

    override fun addItem(index: Int) {
        sampleAdapter?.addItem(index)
    }

    override fun adapterNotify() {
        sampleAdapter?.notifyDataSetChanged()
    }
}