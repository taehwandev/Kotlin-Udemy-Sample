package tech.thdev.kotlin_udemy_sample.class_02

/**
 * Created by tae-hwan on 09/10/2016.
 *
 * kotlin의 interface는 Java 8의 virtual을 사용할 수 있습니다
 * https://blog.jooq.org/2011/12/18/java-8-virtual-extension-methods/
 */
interface _02_Interface {

    var attributeA: String
    val attributeB: String/* = "ABC"*/

    fun methodA() {
        println("methodA")
    }

    fun methodB(): String
}

/*open*/ class InterfaceSample : _02_Interface {

    override var attributeA: String = "AttributeA"

    // 상속에 대한 구현으로 get/set을 사용한다.
    // 참고자료 : https://kotlinlang.org/docs/reference/properties.html#backing-fields
    override var attributeB: String = ""
        get() = field
        set(value) {
            field = value
        }

    // methodA는 interface에서 이미 정의되어 있지만, 다음과 같이 함수 재정의가 가능합니다
//    override fun methodA() {
//        super.methodA()
//    }

    override fun methodB(): String = "methodB"
}

// TODO 아래의 Test 코드는 오류가 발생합니다
// TODO 오류의 이유를 찾고 해결해보세요
//class Test : InterfaceSample() {
//
//    override fun methodA() {
//        super.methodA()
//    }
//
//    override fun methodB(): String {
//        return super.methodB()
//    }
//}