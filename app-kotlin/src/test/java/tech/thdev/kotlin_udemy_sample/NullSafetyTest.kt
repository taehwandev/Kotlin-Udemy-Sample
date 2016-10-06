package tech.thdev.kotlin_udemy_sample

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 *
 * 실행 방법
 *
 * @Test가 포함된 함수의 오른쪽 마우스를 누른 상태에서 Run을 하시면 됩니다
 */
class NullSafetyTest {

    /**
     * 안전한 null 처리의 가장 일반적인 방법입니다.
     * if name != null 인 경우에만 length를 포함하게 됩니다
     */
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

    /**
     * 안전한 NULL 처리 중
     * ?.을 이용하여 처리합니다.
     * name이 null이라면 return 역시 null이 됩니다
     */
    @Test
    @Throws(InterruptedException::class)
    fun testNullCheck2() {
        val name: String? = null
        println(getLength2(name))
    }

    private fun getLength2(name: String?): Int? {
        return name?.length
    }

    /**
     * 안전한 NULL 처리 중
     * try/catch 함수를 이용하여 처리합니다
     */
    @Test
    @Throws(InterruptedException::class)
    fun testNullCheck3() {
        val name: String? = null
        println(getLength3(name))
    }

    private fun getLength3(name: String?): Int {
        return try {
            name!!.length
        } catch (e: Exception) {
            0
        }
    }
}