package tech.thdev.kotlin_udemy_sample.view.main

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.R

/**
 * Created by tae-hwan on 10/3/16.
 */
class MainFragment : Fragment() {

    private val recyclerView by lazy {
        view?.findViewById(R.id.recycler_view) as RecyclerView
    }

    private val fab by lazy {
        activity.findViewById(R.id.fab) as FloatingActionButton
    }

    // Java 식의 static instance
    companion object {
        fun getInstance() = MainFragment()
    }

    private var sampleAdapter: SampleAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sampleAdapter = SampleAdapter(context)
        recyclerView.adapter = sampleAdapter

        sampleAdapter?.let {
            addItems(0)
            sampleAdapter?.notifyDataSetChanged()
        }

        fab.setOnClickListener {
            // item을 500개보다 작은 동안 추가한다
            sampleAdapter?.let {
                if (it.itemCount < 50) {
                    addItems(it.itemCount)
                    sampleAdapter?.notifyDataSetChanged()
                }
            }
        }
    }

    private fun addItems(size: Int) {
        val tempSize = size + 1
        val tempCount = (size / 10) + 1
        for (index in tempSize..(10 * tempCount)) {
            sampleAdapter?.addItem(index)
        }
    }
}