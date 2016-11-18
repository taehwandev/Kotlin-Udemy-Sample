package tech.thdev.sample_putextra.view.extra

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sample.*
import tech.thdev.sample_putextra.R
import tech.thdev.sample_putextra.constant.Constant

/**
 * Created by tae-hwan on 11/18/16.
 */
class ExtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        intent.getStringExtra(Constant.KEY_TITLE)?.let {
            tv_title.text = it
        }
        intent.getStringExtra(Constant.KEY_MESSAGE)?.let {
            tv_message.text = it
        }
        img_view.setImageResource(intent.getIntExtra(Constant.KEY_PHOTO, 0))
    }
}