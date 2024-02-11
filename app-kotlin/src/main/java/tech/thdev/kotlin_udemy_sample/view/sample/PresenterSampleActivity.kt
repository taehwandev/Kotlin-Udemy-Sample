package tech.thdev.kotlin_udemy_sample.view.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.databinding.ActivityMainBinding
import tech.thdev.kotlin_udemy_sample.util.replaceFragmentToActivity

class PresenterSampleActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.toolbar.setTitle(R.string.app_name)
        setSupportActionBar(activityMainBinding.toolbar)

        replaceFragmentToActivity(PresenterSampleFragment.getInstance(), R.id.frame_layout)
    }
}
