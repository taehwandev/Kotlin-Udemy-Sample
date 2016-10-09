package tech.thdev.kotlin_udemy_sample.class_02

/**
 * Created by tae-hwan on 09/10/2016.
 */

abstract class _01_Abstract {

    abstract var attributeA: String

    // 상속 후 재 정의를 하지 못함
    var attributeB: String = "AttributeB"

    abstract fun methodA()

    // 상속 후 재 정의를 하지 못함
    fun methodB(): String {
        return attributeA
    }
}

class AbstractSample : _01_Abstract() {

    override var attributeA: String = "AttributeA"

    override fun methodA() {
        println("---------")
        println("methodA")
        println("---------")
    }
}