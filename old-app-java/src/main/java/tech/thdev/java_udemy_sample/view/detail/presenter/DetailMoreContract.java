package tech.thdev.java_udemy_sample.view.detail.presenter;

import tech.thdev.base.presenter.BasePresenter;
import tech.thdev.base.presenter.BaseView;
import tech.thdev.java_udemy_sample.data.FlickrPhoto;

/**
 * Created by tae-hwan on 11/17/16.
 */

public interface DetailMoreContract {

    interface View extends BaseView {

        void showPhotoItem(FlickrPhoto photo);
    }

    interface Presenter extends BasePresenter<View> {

        void onLoadPhotoInfo(String photoId);
    }
}
