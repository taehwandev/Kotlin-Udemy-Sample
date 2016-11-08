package tech.thdev.kotlin_udemy_sample.view.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_basic.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.adapter.TestAdapter
import java.util.*

/**
 * Created by tae-hwan on 11/8/16.
 */

class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        val list = ArrayList<String>()
        for (index in 1..50) {
            list.add("Index $index")
        }

        // TODO RecyclerView 어댑터 추가
        val adapter = TestAdapter(this)
        adapter.list = list
        // Kotlin extensions을 적용하여 recyclerView와 연결해보세요

        // TODO LayoutManager 정의
        // XML을 통해서 하거나, recycler adapter을 이용하세요.
    }
}