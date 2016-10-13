package tech.thdev.kotlin_udemy_sample.class_02

/**
 * Created by tae-hwan on 09/10/2016.
 */

// kotlin의 Abstract는 함수의 재 정의가 기본적으로 불가능
// open class를 생성하여야 재 정의 가능한 형태의 함수가 생성됩니다

open class _03_Open {

    open fun methodA() {}
    fun methodB() {
        println("final method ...")
    }
}

class OpenSample : _03_Open() {

    override fun methodA() {
        println("Functions of financial")
    }

    // methodB는 final이라서 함수 재 정의가 불가능
//    override fun methodB() {
//        // final and cannot be override
//    }
}

/**
 * OpenSample의 경우 final이기 때문에 클래스 재 정의가 불가능
 */
//class OpenSample2 : OpenSample() {
//
//}