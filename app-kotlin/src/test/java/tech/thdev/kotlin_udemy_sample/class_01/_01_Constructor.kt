package tech.thdev.kotlin_udemy_sample.class_01

/**
 * Created by tae-hwan on 09/10/2016.
 *
 * 생성자 기본
 */

class Constructor(val name: String) {

    fun get(): String = name
}

/**
 * 생성자 기본의 원형
 */
class Constructor2 constructor(val name: String) {

}