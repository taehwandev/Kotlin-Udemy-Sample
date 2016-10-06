package tech.thdev.kotlin_udemy_sample

import org.junit.Test

/**
 * Created by tae-hwan on 10/6/16.
 */
class NullSafetyClassTest {
    internal inner class A(var b: B?)
    internal inner class B(var c: C?)
    internal inner class C {
        val name: String
            get() = "class C"
    }

    @Test
    @Throws(InterruptedException::class)
    fun test() {
        val c: C? = null
        val b = B(c)
        val a = A(b)

        if (c != null && b != null && a != null) {
            print(a?.b?.c?.name)
        } else {
            print("NULL")
        }
    }
}