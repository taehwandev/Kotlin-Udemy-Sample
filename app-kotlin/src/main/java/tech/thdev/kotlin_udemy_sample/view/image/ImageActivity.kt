package tech.thdev.kotlin_udemy_sample.view.image

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.databinding.ActivityImageSampleBinding
import tech.thdev.kotlin_udemy_sample.util.replaceFragmentToActivity

class ImageActivity : AppCompatActivity() {

    private lateinit var activityImageSampleBinding: ActivityImageSampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityImageSampleBinding = ActivityImageSampleBinding.inflate(layoutInflater)
        setContentView(activityImageSampleBinding.root)

        activityImageSampleBinding.toolbar.setTitle(R.string.app_name)
        setSupportActionBar(activityImageSampleBinding.toolbar)

        replaceFragmentToActivity(ImageFragment.getInstance(), R.id.frame_layout)
    }
}
