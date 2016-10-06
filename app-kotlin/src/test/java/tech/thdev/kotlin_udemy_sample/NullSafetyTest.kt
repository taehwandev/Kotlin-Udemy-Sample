package tech.thdev.kotlin_udemy_sample

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 */
class NullSafetyTest {

    @Test
    @Throws(InterruptedException::class)
    fun testNullCheck() {
        val name: String? = null
        println(getLength(name))
    }

    private fun getLength(name: String?): Int {
        if (name != null) {
            return name.length
        }
        return 0
    }





























    private fun getLength2(name: String?): Int? {
        return name?.length
    }

    private fun getLength3(name: String?): Int {
        return try {
            name!!.length
        } catch (e: Exception) {
            0
        }
    }
}