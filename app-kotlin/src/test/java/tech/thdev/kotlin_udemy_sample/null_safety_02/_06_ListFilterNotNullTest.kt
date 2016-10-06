package tech.thdev.kotlin_udemy_sample.null_safety_02

import org.junit.Test

/**
 * Created by tae-hwan on 10/7/16.
 *
 * List에서 null을 제거하는 방법을 정리하였습니다
 */
class _06_ListFilterNotNullTest {

    @Test
    @Throws(InterruptedException::class)
    fun test() {
        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        for (i in nullableList) {
            print("${i} ")
        }
        println("")

        // null filter
        val intList: List<Int> = nullableList.filterNotNull()
        for (i in intList) {
            print("${i} ")
        }
    }
}