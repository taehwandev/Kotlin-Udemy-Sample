package tech.thdev.java_udemy_sample.view.mvp.presenter;

/**
 * Created by tae-hwan on 10/22/16.
 */

public class MVPImpl implements MVPPresenter {

    private MVPPresenter.View view;

    public MVPImpl(MVPPresenter.View view) {
        this.view = view;
    }

    @Override
    public void getItems(int size) {
        // size를 체크한다. 현재 아이템의 사이즈가 50 보다 작을 동안에만 10개씩 추가한다
        if (size < 50) {
            size = size + 1;
            int count = (size / 10) + 1;
            for (int i = size; i < (10 * count); i++) {
                // Adapter에 아이템을 add 한다
                view.addItem(i);
            }

            // View의 Adapter를 갱신한다
            view.adapterNotify();
        }
    }
}
