package tech.thdev.kotlin_udemy_sample.class_02

import org.junit.Test

/**
 * Created by tae-hwan on 09/10/2016.
 */

class _01_AbstractTest {

    @Test
    @Throws(Exception::class)
    fun test() {
        val sample = AbstractSample()

        sample.attributeA = "Test A"
        println(sample.attributeA)
//        sample.attributeB = "Test B"
        println(sample.attributeB)
        sample.methodA()
        println(sample.methodB())
    }
}