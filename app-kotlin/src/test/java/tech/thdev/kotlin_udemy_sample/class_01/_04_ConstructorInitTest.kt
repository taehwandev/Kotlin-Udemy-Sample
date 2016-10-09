package tech.thdev.kotlin_udemy_sample.class_01

import org.junit.Test

/**
 * Created by tae-hwan on 09/10/2016.
 */
class _04_ConstructorInitTest {

    @Test
    @Throws(Exception::class)
    fun test() {
        println(_03_ConstructorInit.InitClass().name)
        println(_03_ConstructorInit.InitClass("ABC").name)
        println(_03_ConstructorInit.ConstructorInit("ConstructorInit...").name)
    }
}