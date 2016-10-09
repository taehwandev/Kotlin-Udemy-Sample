package tech.thdev.java_udemy_sample._01_constructor;

/**
 * Created by tae-hwan on 09/10/2016.
 */

public class _02_MultiConstructor {

    public _02_MultiConstructor(String name) {

    }

    public _02_MultiConstructor(String name, int age) {
        this(name);
    }
}
