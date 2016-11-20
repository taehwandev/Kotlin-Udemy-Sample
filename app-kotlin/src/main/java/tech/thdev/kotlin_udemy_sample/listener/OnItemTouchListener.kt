package tech.thdev.kotlin_udemy_sample.listener

import android.view.MotionEvent

/**
 * Created by tae-hwan on 11/20/16.
 */

interface OnItemTouchListener {

    fun onItemTouch(motionEvent: MotionEvent?, position: Int): Boolean
}