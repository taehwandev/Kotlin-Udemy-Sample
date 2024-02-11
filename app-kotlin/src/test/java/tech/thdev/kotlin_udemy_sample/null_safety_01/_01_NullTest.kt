package tech.thdev.kotlin_udemy_sample.null_safety_01

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 *
 * 실행 방법
 *
 * @Test가 포함된 함수의 오른쪽 마우스를 누른 상태에서 Run을 하시면 됩니다
 */
class _01_NullTest {

    /**
     * null이 날 수 있는 상황을 설명하기 위한 테스트 코드입니다
     */
    @Test
    @Throws(InterruptedException::class)
    fun testNullable() {
        val name: String = "Name"
        print(getLength(name))
    }

    /**
     * null이 날 수 있는 상황을 설명하기 위한 테스트 코드입니다
     */
    @Test
    @Throws(InterruptedException::class)
    fun testNull() {
        val name = null
        print(getLength(name))
    }

    private fun getLength(name: String?): Int? {
        return name?.length
    }
}