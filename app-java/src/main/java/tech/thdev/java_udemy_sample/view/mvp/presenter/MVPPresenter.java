package tech.thdev.java_udemy_sample.view.mvp.presenter;

/**
 * Created by tae-hwan on 10/22/16.
 */

public interface MVPPresenter {

    /**
     * RecyclerView에 사용될 아이템을 가져온다
     */
    void getItems(int size);

    interface View {

        /**
         * RecyclerView에 아이템을 추가한다
         */
        void addItem(int index);

        /**
         * RecyclerView를 갱신한다
         */
        void adapterNotify();
    }
}
