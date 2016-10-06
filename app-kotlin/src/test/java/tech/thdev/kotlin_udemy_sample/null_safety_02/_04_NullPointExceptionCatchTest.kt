package tech.thdev.kotlin_udemy_sample.null_safety_02

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 *
 * Kotlin에서의 NullPointException 예외처리
 */
class _04_NullPointExceptionCatchTest {

    /**
     * try/catch를 이용한 예외처리
     */
    @Test
    @Throws(InterruptedException::class)
    fun test() {
        val temp: String? = null
        val size: Int
        try {
            size = temp!!.length
        } catch (e: Exception) {
            size = 0
        }
        print(size)
    }

    /**
     * 1.0.4 버전 부터는 다음과 같이 try / catch를 사용하여야 한다.
     * 1.0.5 부터는 아래와 같지 않으면 오류 발생
     */
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