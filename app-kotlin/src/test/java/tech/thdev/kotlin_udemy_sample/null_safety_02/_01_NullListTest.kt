package tech.thdev.kotlin_udemy_sample.null_safety_02

import org.junit.Test

/**
 * Created by tae-hwan on 10/7/16.
 *
 * 일반적인 null을 배제하는 방법
 */
class _01_NullListTest {

    /**
     * if 문으로 null 체크하는 일반적인 코드
     */
    @Test
    @Throws(InterruptedException::class)
    fun testList() {
        val listWithNulls: List<String?> = listOf("A", null, "B")
        for (item in listWithNulls) {
            if (item != null) {
                println(item)
            }
        }
    }


    /**
     * ?.let {} 을 이용한 null 제외 코드
     */
    @Test
    @Throws(InterruptedException::class)
    fun testListLet() {
        val listWithNulls: List<String?> = listOf("A", null, "B")
        for (item in listWithNulls) {
            item?.let {
                println(item)
            }
        }
    }
}