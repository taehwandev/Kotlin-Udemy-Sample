package tech.thdev.java_udemy_sample.view.image.adapter.model;

import tech.thdev.java_udemy_sample.data.PhotoItem;
import tech.thdev.java_udemy_sample.listener.OnItemClickListener;

/**
 * Created by tae-hwan on 11/8/16.
 */

public interface PhotoViewAdapterContract {

    interface View {

        void onReload();

        void setOnItemClickListener(OnItemClickListener onItemClickListener);
    }

    interface Model {

        void addItem(PhotoItem item);

        PhotoItem getItem(int position);
    }
}
