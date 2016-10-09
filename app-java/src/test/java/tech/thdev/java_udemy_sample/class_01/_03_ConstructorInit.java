package tech.thdev.java_udemy_sample.class_01;

/**
 * Created by tae-hwan on 09/10/2016.
 *
 * 생성자에서의 초기화
 */

public class _03_ConstructorInit {

    public static class InnerClass {

        private String name;

        public InnerClass() {
            name = "InnerClass";
        }

        public String getName() {
            return name;
        }
    }
}
