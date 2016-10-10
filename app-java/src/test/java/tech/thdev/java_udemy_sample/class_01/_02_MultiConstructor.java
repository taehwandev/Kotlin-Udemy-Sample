package tech.thdev.java_udemy_sample.class_01;

/**
 * Created by tae-hwan on 09/10/2016.
 * <p>
 * 다중 생성자
 */

public class _02_MultiConstructor {

    private String name;
    private int age;

    public _02_MultiConstructor(String name) {
        this.name = name;
        this.age = 0;
    }

    public _02_MultiConstructor(String name, int age) {
        this(name);
        this.age = age;
    }
}
