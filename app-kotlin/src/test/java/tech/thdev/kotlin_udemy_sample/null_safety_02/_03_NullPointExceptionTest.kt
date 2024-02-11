package tech.thdev.kotlin_udemy_sample.null_safety_02

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 *
 * NullPointException을 발생시키는 방법
 */
class _03_NullPointExceptionTest {

    @Test
    @Throws(InterruptedException::class)
    fun testNullPointException() {
        var temp: String? = null
        val size = temp?.length ?: throw NullPointerException("temp is null")
        print(size)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testNullPointException2() {
        var temp: String? = null
        val size = temp!!.length
        print(size)
    }
}