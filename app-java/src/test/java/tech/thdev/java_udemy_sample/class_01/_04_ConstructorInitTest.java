package tech.thdev.java_udemy_sample.class_01;

import org.junit.Test;

/**
 * Created by tae-hwan on 09/10/2016.
 * <p>
 * 클래스 사용하기
 */

public class _04_ConstructorInitTest {

    @Test
    public void test() throws Exception {
        _03_ConstructorInit.InnerClass init = new _03_ConstructorInit.InnerClass();
        System.out.println(init.getName());
    }
}
