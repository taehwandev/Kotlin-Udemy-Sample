package tech.thdev.sample_putextra.view.parcelable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.sample_putextra.R
import tech.thdev.sample_putextra.constant.Constant
import tech.thdev.sample_putextra.data.SampleData
import tech.thdev.sample_putextra.databinding.ActivitySampleBinding

/**
 * Created by tae-hwan on 11/18/16.
 */

class ParcelableActivity : AppCompatActivity() {

    private lateinit var activitySampleBinding: ActivitySampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySampleBinding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(activitySampleBinding.root)

        // TODO SampleData에 대해서 Parcelable 작성
//        intent.getParcelableExtra<SampleData>(Constant.KEY_PARCELABLE_DATA)?.let {
//            activitySampleBinding.tvTitle.text = it.title
//            activitySampleBinding.tvMessage.text = it.message
//            activitySampleBinding.imgView.setImageResource(it.photo)
//        }
    }
}