package tech.thdev.app.util

import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import java.util.*

/**
 * Created by record-tae on 10/21/17.
 */
fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: android.support.v4.app.Fragment, tag: String? = null) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()
}

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start)