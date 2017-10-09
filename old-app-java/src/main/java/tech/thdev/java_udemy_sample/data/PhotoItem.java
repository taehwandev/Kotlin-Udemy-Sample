package tech.thdev.java_udemy_sample.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tae-hwan on 11/7/16.
 */

public class PhotoItem {

    private String id;
    private String owner;
    private String secret;
    private String server;
    private long farm;
    private String title;
    private int viewType;

    @SerializedName("ispublic")
    private long isPublic;

    @SerializedName("isfriend")
    private long isFriend;

    @SerializedName("isfamily")
    private long isFamily;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public long getFarm() {
        return farm;
    }

    public void setFarm(long farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(long isPublic) {
        this.isPublic = isPublic;
    }

    public long getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(long isFriend) {
        this.isFriend = isFriend;
    }

    public long getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(long isFamily) {
        this.isFamily = isFamily;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getUrl() {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s.jpg", farm, server, id, secret);
    }
}
