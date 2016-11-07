package tech.thdev.java_udemy_sample.view.image.presenter;

/**
 * Created by tae-hwan on 10/29/16.
 */

public interface PhotoViewPresenter {

    void recentPhotoData();

    interface View {

        void showLoaded();

        void showFailLoaded();
    }
}
