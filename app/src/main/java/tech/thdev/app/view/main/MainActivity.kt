package tech.thdev.app.view.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.thdev.app.R
import tech.thdev.app.util.replace
import tech.thdev.app.view.main.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replace(R.id.container, HomeFragment.getInstance(R.string.title_home), "HOME")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                replace(R.id.container, HomeFragment.getInstance(R.string.title_dashboard), "DASHBOARD")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                replace(R.id.container, HomeFragment.getInstance(R.string.title_notifications), "NOTIFICATION")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replace(R.id.container, HomeFragment.getInstance(R.string.title_home), "HOME")
    }
}
