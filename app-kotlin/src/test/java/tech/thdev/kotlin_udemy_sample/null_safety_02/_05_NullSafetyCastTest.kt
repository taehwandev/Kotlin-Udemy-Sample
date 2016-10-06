package tech.thdev.kotlin_udemy_sample.null_safety_02

import org.junit.Test

/**
 * Created by tae-hwan on 10/7/16.
 */
class _05_NullSafetyCastTest {

    @Test
    @Throws(InterruptedException::class)
    fun test() {
        val a: String? = "ABC"

        // String을 강제로 형 변환 할 경우에는 CastException이 발생하여 이 경우 null이 저장
        val aInt: Int? = a as? Int?
        println(aInt)

        // null이 아닌 0을 저장하려면
        val aIntTwo: Int? = a as? Int? ?: 0
        println(aIntTwo)
    }
}