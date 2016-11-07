package tech.thdev.java_udemy_sample.view.image.presenter;

import tech.thdev.java_udemy_sample.adapter.model.PhotoViewAdapterContract;

/**
 * Created by tae-hwan on 10/29/16.
 */

public interface PhotoViewPresenter {

    /**
     * Adapter의 Model을 셋팅한다
     */
    void setAdapterModel(PhotoViewAdapterContract.Model adapterModel);

    /**
     * Adapter의 View를 셋팅한다
     */
    void setAdapterView(PhotoViewAdapterContract.View adapterView);

    void recentPhotoData();

    interface View {

        void showLoaded();

        void showFailLoaded();

        void showLoadFailMessage(int code, String message);
    }
}
