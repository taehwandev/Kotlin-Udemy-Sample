package tech.thdev.app.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import tech.thdev.app.R
import tech.thdev.app.databinding.ActivityMainBinding
import tech.thdev.app.util.replace
import tech.thdev.app.view.main.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private val homeFragment: HomeFragment by lazy {
        HomeFragment()
    }

    private val cameraFragment: CameraFragment by lazy {
        CameraFragment().apply {
            arguments = Bundle().apply {
                putInt(CameraFragment.KEY_TITLE, R.string.title_camera)
            }
        }
    }

    private val moreFragment: MoreFragment by lazy {
        MoreFragment().apply {
            arguments = Bundle().apply {
                putInt(MoreFragment.KEY_TITLE, R.string.title_more)
            }
        }
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replace(R.id.container, homeFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_camera -> {
                    replace(R.id.container, cameraFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_more -> {
                    replace(R.id.container, moreFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        replace(R.id.container, homeFragment)

        activityMainBinding.navigation.setOnNavigationItemSelectedListener(
            mOnNavigationItemSelectedListener
        )
    }
}
