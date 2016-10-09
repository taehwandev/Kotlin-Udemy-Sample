package tech.thdev.java_udemy_sample.class_02;

/**
 * Created by tae-hwan on 09/10/2016.
 */

/**
 * Java에서는 모든 함수가 재정의가 가능하다
 */
public abstract class _01_Abstract {

    public String attributeA;
    public String attributeB = "AttributeB";

    public abstract void methodA();

    /**
     * final을 사용할 경우 함수 재정의가 불가능하다
     */
    public final String methodB() {
        return attributeA;
    }
}

class AbstractSample extends _01_Abstract {

    @Override
    public void methodA() {
        System.out.println("methodA");
    }

    /**
     * final로 감싸두어서 Override를 할 수 없다
     */
//    @Override
//    public String methodB() {
//        return "";
//    }
}
