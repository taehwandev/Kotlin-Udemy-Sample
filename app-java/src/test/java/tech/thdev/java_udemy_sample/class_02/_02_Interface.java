package tech.thdev.java_udemy_sample.class_02;

/**
 * Created by tae-hwan on 09/10/2016.
 */

public interface _02_Interface {

    // final이 생략가능하며 값을 변경할 수 없는 final로 사용된다
    final String attributeA = null;
    String attributeB = "AttributeB";

    void methodA();

    /**
     * final을 사용할 경우 함수 재정의가 불가능하다
     *
     * java에서는 body를 가질 수 없음
     */
//    String methodB() {
//        return attributeA;
//    }
    String methodB();
}

class InterfaceSample implements _02_Interface {

    @Override
    public void methodA() {
        System.out.println("methodA");
    }

    @Override
    public String methodB() {
        return "Interface MethodB";
    }
}
