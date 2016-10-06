package tech.thdev.kotlin_udemy_sample

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 */
class NullTest {

    @Test
    @Throws(InterruptedException::class)
    fun testNullable() {
        val name = "Name"
        print(getLength(name))
    }

    private fun getLength(name: String?): Int {
        return name!!.length
    }


































    @Test
    @Throws(InterruptedException::class)
    fun testNull() {
        val name = null
        print(getLength(name))
    }
}