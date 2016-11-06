package tech.thdev.java_udemy_sample.view.sample.presenter;

import android.content.Context;

import tech.thdev.java_udemy_sample.data.SampleItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public interface SamplePresenter {

    void updateImageData(Context context);

    interface View {

        void notifyAdapter();

        void addItem(SampleItem imageItem);
    }
}
