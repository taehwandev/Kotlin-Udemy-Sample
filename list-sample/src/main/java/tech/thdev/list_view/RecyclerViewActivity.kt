package tech.thdev.list_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.list_sample.databinding.ActivityRecyclerViewBinding

/**
 * Created by tae-hwan on 10/22/17.
 */
class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var activityRecyclerViewBinding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRecyclerViewBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(activityRecyclerViewBinding.root)
    }
}