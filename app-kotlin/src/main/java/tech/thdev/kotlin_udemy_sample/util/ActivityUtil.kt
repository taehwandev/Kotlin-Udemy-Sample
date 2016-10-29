package tech.thdev.kotlin_udemy_sample.util

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by tae-hwan on 10/3/16.
 */

fun AppCompatActivity.replaceFragmentToActivity(fragment: Fragment, frameId: Int) {
    val transaction = this.supportFragmentManager.beginTransaction()
    transaction.replace(frameId, fragment)
    transaction.commit()
}