package tech.thdev.kotlin_udemy_sample.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.util.replaceFragmentToActivity

class MainActivity : AppCompatActivity() {

    private val toolbar by lazy {
        findViewById<Toolbar>(R.id.toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        // TODO 유틸로 함수 변경
//        supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.frame_layout, MainFragment.getInstance())
//                .commit()
        replaceFragmentToActivity(MainFragment.getInstance(), R.id.frame_layout)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }
}
