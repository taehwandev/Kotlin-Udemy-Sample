package tech.thdev.app.util

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by record-tae on 10/10/17.
 */

fun AppCompatActivity.replace(containerViewId: Int, fragment: Fragment, tag: String?) {
    supportFragmentManager.beginTransaction().replace(containerViewId, fragment, tag).commitAllowingStateLoss()
}