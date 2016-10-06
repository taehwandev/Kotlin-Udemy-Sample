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
            // 일반적인 방법
            item?.let { print(item )}

            // it 키워드를 사용할 경우
            // let 블락 함수 이후에는 it 키워드를 사용할 수 있음.(단, 1개의 변수만 있을 경우)
            item?.let { print(it) }

            // Lambda 식으로 대체
//            item?.let(::println)
        }
    }
}