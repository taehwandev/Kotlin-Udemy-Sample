package tech.thdev.java_udemy_sample.data.source.image;

import java.util.List;

import tech.thdev.java_udemy_sample.data.PhotoItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public interface ImageSource {

    interface LoadImageCallback {

        /**
         * 로드 성공시 데이터를 넘겨준다
         */
        void onImageLoaded(List<PhotoItem> photoItems);

        /**
         * 로드 실패시
         */
        void onDataNotAvailable();

        /**
         * 로드 실패에 대한 메시지
         */
        void onLoadFail(int code, String message);
    }

    /**
     * image items
     */
    void getImageItems(int page, LoadImageCallback loadImageCallback);
}
