package tech.thdev.java_udemy_sample.class_02;

/**
 * Created by tae-hwan on 09/10/2016.
 *
 * Kotlin에서는 open을 통해 함수 재정의를 일부 허용 해준다
 *
 * java는 기본이 open이라서 final을 통해서 함수 재정의를 막을 수 있다
 *
 * 아래 예는 fianl을 통해 함수 재정의를 막는 예제이다
 */

public /*final*/ class _03_Open {

    public void methodA() {
        System.out.println("methodA");
    }

    // 함수 재정의 불가능
    public final void methodB() {
        System.out.println("methodB");
    }
}

class FinalSample extends _03_Open {

    @Override
    public void methodA() {
        System.out.println("");
    }
}

class FinalSampe2 extends FinalSample {
    @Override
    public void methodA() {
        super.methodA();
    }
}
