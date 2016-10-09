package tech.thdev.kotlin_udemy_sample._01_constructor

/**
 * Created by tae-hwan on 09/10/2016.
 */

/**
 * 다중 생성자
 */

// 첫 번째 기본 생성자
class _01_Constructor(val name: String) {

    // 두 번째 생성자
    constructor(name: String, age: Int) : this(name)
}