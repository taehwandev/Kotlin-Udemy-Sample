package tech.thdev.java_udemy_sample;

import android.support.annotation.Nullable;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/6/16.
 */

public class NullSafetyTest {

    @Test
    public void testNullCheck() throws InterruptedException {
        String name = null;
        System.out.print(getLength(name));
    }

    private int getLength(@Nullable String name) {
        if (name != null) {
            return name.length();
        }
        return 0;
    }
}
