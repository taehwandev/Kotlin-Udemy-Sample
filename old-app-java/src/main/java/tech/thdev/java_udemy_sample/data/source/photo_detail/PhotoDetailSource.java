package tech.thdev.java_udemy_sample.data.source.photo_detail;

import tech.thdev.java_udemy_sample.data.FlickrPhoto;

/**
 * Created by tae-hwan on 10/29/16.
 */

public interface PhotoDetailSource {

    interface LoadImageCallback {

        /**
         * 로드 성공시 데이터를 넘겨준다
         */
        void onImageLoaded(FlickrPhoto photo);

        /**
         * 로드 실패시
         */
        void onDataNotAvailable();
    }

    /**
     * image items
     */
    void getImageItems(String photoId, LoadImageCallback loadImageCallback);
}
