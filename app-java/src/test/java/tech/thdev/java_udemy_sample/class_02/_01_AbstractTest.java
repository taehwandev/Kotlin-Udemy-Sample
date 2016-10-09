package tech.thdev.java_udemy_sample.class_02;

import org.junit.Test;

/**
 * Created by tae-hwan on 09/10/2016.
 */

public class _01_AbstractTest {

    @Test
    public void test() throws Exception {
        AbstractSample abstractSample = new AbstractSample();
        abstractSample.attributeA = "attributeA";
        System.out.println(abstractSample.attributeA);
        System.out.println(abstractSample.attributeB);
        abstractSample.methodA();
        System.out.println(abstractSample.methodB());
    }
}
