package tech.thdev.java_udemy_sample;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/6/16.
 *
 * 실행 방법
 *
 * @Test가 포함된 함수의 오른쪽 마우스를 누른 상태에서 Run을 하시면 됩니다
 */

public class NullSafetyClassTest {

    class A {
        B b;

        A(B b) {
            this.b = b;
        }
    }
    class B {
        C c;
        B(C c) {
            this.c = c;
        }
    }
    class C {
        public String getName() {
            return "class C";
        }
    }

    /**
     * Java에서 일반적인 null 처리 방법을 제공합니다.
     */
    @Test
    public void test() throws InterruptedException {
        C c = null;
        B b = new B(c);
        A a = new A(b);

        if (c != null && b != null && a != null) {
            System.out.print(a.b.c.getName());
        } else {
            System.out.print("null");
        }
    }
}
