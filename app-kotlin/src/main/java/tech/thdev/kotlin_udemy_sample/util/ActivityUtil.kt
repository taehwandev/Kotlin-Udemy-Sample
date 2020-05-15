package tech.thdev.kotlin_udemy_sample.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


/**
 * Created by tae-hwan on 10/3/16.
 */
// TODO Fragment replace 함수 생성
// 중위 표기법

fun AppCompatActivity.replaceFragmentToActivity(fragment: Fragment, frameId: Int) {
    val transaction = this.supportFragmentManager.beginTransaction()
    transaction.replace(frameId, fragment)
    transaction.commit()
}