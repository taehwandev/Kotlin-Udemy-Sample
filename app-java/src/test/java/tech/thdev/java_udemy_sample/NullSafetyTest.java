package tech.thdev.java_udemy_sample;

import android.support.annotation.Nullable;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/6/16.
 *
 * 실행 방법
 *
 * @Test가 포함된 함수의 오른쪽 마우스를 누른 상태에서 Run을 하시면 됩니다
 */

public class NullSafetyTest {

    /**
     * 일반적인 null 처리 방법을 소개합니다
     * @throws InterruptedException
     */
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
