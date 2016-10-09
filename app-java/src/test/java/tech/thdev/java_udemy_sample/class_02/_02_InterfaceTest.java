package tech.thdev.java_udemy_sample.class_02;

import org.junit.Test;

/**
 * Created by tae-hwan on 09/10/2016.
 */

public class _02_InterfaceTest {

    @Test
    public void test() throws Exception {
        InterfaceSample sample = new InterfaceSample();

        // Java의 interface variable은 final 이라서 값의 변경이 불가능
//        _02_Interface.attributeA = "ABC";
//        sample.attributeB = "BBB";

        System.out.println(_02_Interface.attributeA);
        System.out.println(_02_Interface.attributeB);
        sample.methodA();
        System.out.println(sample.methodB());
    }
}
