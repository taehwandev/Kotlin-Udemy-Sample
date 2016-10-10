package tech.thdev.kotlin_udemy_sample.class_01

/**
 * Created by tae-hwan on 09/10/2016.
 *
 * 생성자에서의 초기화
 */

class _03_ConstructorInit {

    class InitClass() {
//        var name: String = "InitClass"
        var name: String

        // 생성자인 constructor에서는 초기화를 하지 못하고, init에서는 가능
        init {
            name = "InitClass"
        }

        // 아래와 같이 초기화 하여야 name의 값이 변경 됨
        constructor(name: String) : this() {
            this.name = name
        }
    }

    class ConstructorInit(val name: String) {
        // ...
    }
}