package tech.thdev.listviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.listviewsample.adapter.SimpleAdapter
import tech.thdev.listviewsample.adapter.ViewHolderAdapter
import tech.thdev.listviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val itemList = ArrayList<String>()

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        for (index in 0..100) {
            itemList.add("Index : $index")
        }

        activityMainBinding.listSimple.adapter = SimpleAdapter(this, 0, itemList)
        activityMainBinding.listViewHolder.adapter = ViewHolderAdapter(this, 0, itemList)
    }
}
