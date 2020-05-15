package tech.thdev.kotlin_udemy_sample.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.util.replaceFragmentToActivity

class MainActivity : AppCompatActivity() {

    private val toolbar by lazy {
        findViewById<Toolbar>(R.id.toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        replaceFragmentToActivity(MainFragment.getInstance(), R.id.frame_layout)
    }
}
