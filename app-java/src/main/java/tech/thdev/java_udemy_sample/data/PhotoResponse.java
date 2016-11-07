package tech.thdev.java_udemy_sample.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tae-hwan on 11/7/16.
 */

public class PhotoResponse {

    @SerializedName("photos")
    private PhotoPageInfo photoPageInfo;

    public PhotoPageInfo getPhotoPageInfo() {
        return photoPageInfo;
    }

    public void setPhotoPageInfo(PhotoPageInfo photoPageInfo) {
        this.photoPageInfo = photoPageInfo;
    }
}
