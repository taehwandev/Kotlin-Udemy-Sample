package tech.thdev.kotlin_udemy_sample.class_02

import org.junit.Test

/**
 * Created by tae-hwan on 09/10/2016.
 */

class _04_Multiple_Inheritance {

    @Test
    @Throws(Exception::class)
    fun test() {
        // open과 interface의 다중 상속
        val sample = Sample()
        sample.methodA()
    }
}