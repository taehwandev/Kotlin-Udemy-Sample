package tech.thdev.kotlin_udemy_sample.class_01

/**
 * Created by tae-hwan on 09/10/2016.
 *
 * 다중 생성자
 */

// 첫 번째 기본 생성자
class _02_MultiConstructor(val name: String, val age: Int, var temp: Int) {

//    var n: String = ""

    // 두 번째 생성자
    constructor(name: String) : this(name, 0, 0)

    fun get() = temp


    /**
     * 아래와 같이 생성자를 초기화 하였을 경우에는 n에 대해서 접근할 수 없음
     * n: String에 접근을 하기 위해서는 this.n = n과 같은 방식으로 초기화를 해주어야 n 변수에 접근할 수 있음.
     */
    constructor(name: String, age: Int, n: String) : this(name, age, 0) {
//        this.n = n
    }

    fun test() {
        // 아래와 같이 n 변수에 접근할 수 없으므로 전역 변수로 var n: String = ""을 초기화 해주어야 함
//        n.length
    }
}

/**
 * 위와 같은 방식의 기본 생성자 선언을 하지 않고,
 * 다음과 같이 default를 사용하여 클래스의 생성자를 사용해주는 방법이 좋음
 *
 * 하지만 default는 Java에서는 사용할 수 없으므로
 * Java와 혼용되는 클래스를 만들고 싶다면 위와 같은 형태로 초기화 해주어야 함
 */
class DefaultConstructor(val name: String, val age: Int = 0) {

}