package tech.thdev.java_udemy_sample.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tae-hwan on 11/7/16.
 */

public class PhotoResponse {

    @SerializedName("photos")
    private PhotoPageInfo photoPageInfo;

    private int code;
    private String message;
    private String stat;

    public PhotoPageInfo getPhotoPageInfo() {
        return photoPageInfo;
    }

    public void setPhotoPageInfo(PhotoPageInfo photoPageInfo) {
        this.photoPageInfo = photoPageInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStat() {
        return stat;
    }
}
