package tech.thdev.java_udemy_sample.null_safety_02;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/7/16.
 * <p>
 * NullPointException을 발생시키는 방법
 */

public class _03_NullPointExceptionTest {

    @Test
    public void test() throws InterruptedException {
        String temp = null;
        int size = temp.length();
        System.out.println(size);
    }
}
