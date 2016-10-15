package tech.thdev.kotlin_udemy_sample.class_02

/**
 * Created by tae-hwan on 09/10/2016.
 */

abstract class _01_Abstract {

    abstract var attributeA: String

    // 상속 후 재 정의를 하지 못함
    val attributeB: String = "AttributeB"

    abstract fun methodA()

    // 상속 후 재 정의를 하지 못함
    /*open */fun methodB(): String {
        return attributeA
    }
}

class AbstractSample : _01_Abstract() {

    override var attributeA: String = "AttributeA"

    override fun methodA() {
        attributeA = "Sample"

        println("---------")
        println("methodA")
        println("---------")
    }

    /**
     * Method B에대해서 method 재정의를 허용하고 싶다면 `open` 키워드를 추가해야 합니다
     */
//    override fun methodB(): String {
//        return super.methodB()
//    }
}