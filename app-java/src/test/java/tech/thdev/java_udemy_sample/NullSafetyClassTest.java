package tech.thdev.java_udemy_sample;

import org.junit.Test;

/**
 * Created by tae-hwan on 10/6/16.
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

    @Test
    public void test() throws InterruptedException {
        C c = null;
        B b = new B(c);
        A a = new A(b);

        if (c != null && b != null && a != null) {
            System.out.print(a.b.c.getName());
        } else {
            System.out.print("NULL");
        }
    }
}
