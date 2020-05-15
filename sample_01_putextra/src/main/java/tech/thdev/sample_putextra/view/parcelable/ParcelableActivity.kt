package tech.thdev.sample_putextra.view.parcelable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sample.*
import tech.thdev.sample_putextra.R
import tech.thdev.sample_putextra.constant.Constant
import tech.thdev.sample_putextra.data.SampleData

/**
 * Created by tae-hwan on 11/18/16.
 */

class ParcelableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        // TODO SampleData에 대해서 Parcelable 작성
//        intent.getParcelableExtra<SampleData>(Constant.KEY_PARCELABLE_DATA)?.let {
//            tv_title.text = it.title
//            tv_message.text = it.message
//            img_view.setImageResource(it.photo)
//        }
    }
}