package tech.thdev.kotlin_udemy_sample.null_safety_01

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 *
 * 실행 방법
 *
 * @Test가 포함된 함수의 오른쪽 마우스를 누른 상태에서 Run을 하시면 됩니다
 */
class _03_NullSafetyClassTest {
    internal inner class A(var b: B?)
    internal inner class B(var c: C?)
    internal inner class C {
        val name: String
            get() = "class C"
    }

    /**
     * A, B, C 클래스에 대한 안전한 null 처리를 할 수 있습니다
     * A, B, C 클래스 중에서 하나라도 null이 있다면 if (null != )의 형태가 아닌
     * 다음과 같은 ?.을 이용하여 안전한 null 처리가 가능합니다
     */
    @Test
    @Throws(InterruptedException::class)
    fun test() {
        val c: C? = C()
        val b: B? = null
        val a: A? = A(b)

        print(a?.b?.c?.name)
    }
}