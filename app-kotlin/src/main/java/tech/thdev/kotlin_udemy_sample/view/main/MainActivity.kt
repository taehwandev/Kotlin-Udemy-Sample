package tech.thdev.kotlin_udemy_sample.view.main

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.util.replaceFragmentToActivity

class MainActivity : AppCompatActivity() {

    private val toolbar by lazy {
        findViewById(R.id.toolbar) as Toolbar
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

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }
}
