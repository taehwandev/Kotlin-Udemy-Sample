package tech.thdev.sample_putextra.view.extra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.sample_putextra.constant.Constant
import tech.thdev.sample_putextra.databinding.ActivitySampleBinding

/**
 * Created by tae-hwan on 11/18/16.
 */
class ExtraActivity : AppCompatActivity() {

    private lateinit var activitySampleBinding: ActivitySampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySampleBinding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(activitySampleBinding.root)

        intent.getStringExtra(Constant.KEY_TITLE)?.let {
            activitySampleBinding.tvTitle.text = it
        }
        intent.getStringExtra(Constant.KEY_MESSAGE)?.let {
            activitySampleBinding.tvMessage.text = it
        }
        activitySampleBinding.imgView.setImageResource(intent.getIntExtra(Constant.KEY_PHOTO, 0))
    }
}