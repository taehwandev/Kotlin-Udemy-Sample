package tech.thdev.listviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.thdev.listviewsample.adapter.SimpleAdapter
import tech.thdev.listviewsample.adapter.ViewHolderAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    private val itemList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (index in 0..100) {
            itemList.add("Index : $index")
        }

        list_simple.adapter = SimpleAdapter(this, 0, itemList)
        list_view_holder.adapter = ViewHolderAdapter(this, 0, itemList)
    }
}
