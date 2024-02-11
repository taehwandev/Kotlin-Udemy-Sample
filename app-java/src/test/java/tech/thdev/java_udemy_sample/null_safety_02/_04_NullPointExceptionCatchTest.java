package tech.thdev.java_udemy_sample.null_safety_02;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/6/16.
 * <p>
 * Java에서의 NullPointException 예외처리
 */

public class _04_NullPointExceptionCatchTest {

    @Test
    public void test() throws InterruptedException {
        String name = null;
        int size;
        try {
            size = name.length();
        } catch (Exception e) {
            size = 0;
        }

        System.out.println(size);
    }
}
