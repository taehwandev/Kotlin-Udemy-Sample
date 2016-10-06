package tech.thdev.java_udemy_sample.null_safety_02;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/7/16.
 */

public class _02_ReturnTest {

    @Test
    public void test() throws InterruptedException {
        String temp = "";
        int size = temp != null ? temp.length() : 0;
        System.out.println(size);
    }
}
