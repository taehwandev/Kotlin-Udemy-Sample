package tech.thdev.kotlin_udemy_sample.class_02

/**
 * Created by tae-hwan on 09/10/2016.
 *
 * kotlin의 interface는 Java 8의 virtual을 사용할 수 있습니다
 * https://blog.jooq.org/2011/12/18/java-8-virtual-extension-methods/
 */
interface _02_Interface {

    var attributeA: String
    var attributeB: String

    fun methodA() {
        println("methodA")
    }

    fun methodB(): String
}

class InterfaceSample : _02_Interface {

    override var attributeA: String = "AttributeA"

    // 상속에 대한 구현으로 get/set을 사용한다.
    // 참고자료 : https://kotlinlang.org/docs/reference/properties.html#backing-fields
    override var attributeB: String = ""
        get() = field
        set(value) {
            field = value
        }

    override fun methodB(): String = "methodB"
}