package tech.thdev.java_udemy_sample.view.image.presenter;

import android.content.Context;

import tech.thdev.java_udemy_sample.data.ImageItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public interface ImageSamplePresenter {

    void updateImageData(Context context);

    interface View {

        void notifyAdapter();

        void addItem(ImageItem imageItem);
    }
}
