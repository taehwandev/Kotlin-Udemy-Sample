package tech.thdev.java_udemy_sample;

import android.support.annotation.Nullable;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/6/16.
 */

public class NullTest {

    @Test
    public void testNullable() throws InterruptedException {
        String name = "Name";
        System.out.print(getLength(name));
    }

    private int getLength(@Nullable String name) {
        return name.length();
    }

































    @Test
    public void testNull() throws InterruptedException {
        String name = null;
        System.out.print(getLength(name));
    }
}
