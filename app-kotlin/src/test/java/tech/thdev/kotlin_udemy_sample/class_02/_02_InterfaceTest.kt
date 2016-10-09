package tech.thdev.kotlin_udemy_sample.class_02

import org.junit.Test

/**
 * Created by tae-hwan on 09/10/2016.
 */

class _02_InterfaceTest {

    @Test
    @Throws(Exception::class)
    fun test() {
        val interfaceSample = InterfaceSample()
        println(interfaceSample.attributeA)
        interfaceSample.attributeB = "Set attributeB"
        println(interfaceSample.attributeB)
        interfaceSample.methodA()
        println(interfaceSample.methodB())
    }
}