package tech.thdev.kotlin_udemy_sample.class_02

/**
 * Created by tae-hwan on 09/10/2016.
 */

/**
 * methodA는 재 정의 가능한 형태의 open 메소드이고
 * methodB는 재정의 불가능한 final 메소드이다
 */
open class OpenBase {
    open fun methodA() {
        println("Open-Base methodA")
    }

    fun methodB() {
        println("Open-Base methodB")
    }
}

/**
 * interface 내에 methodA와 methodC를 정의한다.
 *
 * methodB를 여기서 구현한다면 상속 받은 클래스에서 충돌이 나 오류가 발생
 */
interface InterfaceBase {
    fun methodA() {
        println("Interface methodA")
    }

    fun methodB()

    fun methodC() {
        println("Interface methodB")
    }
}

class Sample : OpenBase(), InterfaceBase {

    /**
     * open class의 open method와 interface의 methodA를 다중상속으로 받는다
     * 아래와 같이 super<Base>를 통해서 각각의 클래스를 호출 가능
     */
    override fun methodA() {
        super<OpenBase>.methodA()
        super<InterfaceBase>.methodA()
    }
}
