package tech.thdev.java_udemy_sample.null_safety_01;


import androidx.annotation.Nullable;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/6/16.
 *
 * 실행 방법
 *
 * @Test가 포함된 함수의 오른쪽 마우스를 누른 상태에서 Run을 하시면 됩니다
 */

public class _01_NullTest {

    /**
     * null이 날 수 있는 상황을 설명하기 위한 테스트 코드입니다
     */
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
