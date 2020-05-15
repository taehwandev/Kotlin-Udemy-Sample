package tech.thdev.kotlin_udemy_sample.view.sample

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_image_sample.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.adapter.sample_one.SampleOneAdapter
import tech.thdev.kotlin_udemy_sample.adapter.sample_two.SampleTwoAdapter
import tech.thdev.kotlin_udemy_sample.listener.OnItemClickListener
import tech.thdev.kotlin_udemy_sample.view.sample.presenter.SampleContract
import tech.thdev.kotlin_udemy_sample.view.sample.presenter.SamplePresenter

/**
 * Created by tae-hwan on 10/3/16.
 */
class SampleFragment : Fragment(), SampleContract.View {

    private val recyclerViewOne by lazy {
        view?.findViewById<RecyclerView>(R.id.recycler_view_one)
    }

    // Java 식의 static instance
    companion object {
        fun getInstance() = SampleFragment()
    }

    private var sampleOneAdapter: SampleOneAdapter? = null
    private var sampleTwoAdapter: SampleTwoAdapter? = null

    private var presenter: SampleContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_image_sample, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create presenter
        presenter = SamplePresenter()
        presenter?.view = this

        // Create adapter
        sampleOneAdapter = SampleOneAdapter(requireContext())

        // Kotlin SAM OnClick lambda
        sampleOneAdapter?.setOnItemClickListener {
            presenter?.adapterOneItemClick(it)
        }

        sampleTwoAdapter = SampleTwoAdapter(requireContext())

        // Object 방법으로 정의
        sampleTwoAdapter?.onItemClickListener = object : OnItemClickListener {

            override fun onItemClick(position: Int) {
                presenter?.adapterTwoItemClick(position)
            }
        }

        presenter?.sampleOneModel = sampleOneAdapter
        presenter?.sampleTwoModel = sampleTwoAdapter

        recyclerViewOne?.adapter = sampleOneAdapter
        recycler_view_two.adapter = sampleTwoAdapter

        presenter?.loadDefaultItems()

        btn_add.setOnClickListener {
            presenter?.adapterOneAddItem()
        }

        btn_delete.setOnClickListener {
            presenter?.adapterTwoRemoveItem()
        }
    }

    override fun adapterOneNotify() {
        sampleOneAdapter?.notifyDataSetChanged()
    }

    override fun onSuccessAddItem(position: Int) {
        Toast.makeText(context, "아이템 추가 완료", Toast.LENGTH_SHORT).show()
        recycler_view_one.scrollToPosition(position)
    }

    override fun adapterTwoNotify() {
        sampleTwoAdapter?.notifyDataSetChanged()
    }

    override fun onSuccessRemoveItem() {
        Toast.makeText(context, "Remove success", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        presenter?.addSampleImageItem()
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccessImageSample(position: Int) {
        recycler_view_one.scrollToPosition(position)
    }
}