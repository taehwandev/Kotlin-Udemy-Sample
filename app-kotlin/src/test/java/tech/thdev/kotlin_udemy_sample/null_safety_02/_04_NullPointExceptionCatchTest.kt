package tech.thdev.kotlin_udemy_sample.null_safety_02

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 *
 * Kotlin에서의 NullPointException 예외처리
 */
class _04_NullPointExceptionCatchTest {

    @Test
    @Throws(InterruptedException::class)
    fun test2() {
        val temp: String? = null
        val size = try {
            temp!!.length
        } catch (e: Exception) {
            0
        }
        print("size $size")
    }
}