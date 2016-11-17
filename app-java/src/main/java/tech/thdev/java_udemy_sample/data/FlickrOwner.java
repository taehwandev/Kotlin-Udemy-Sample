package tech.thdev.java_udemy_sample.data;

/**
 * Created by tae-hwan on 11/17/16.
 */

public class FlickrOwner {

    public String nsid;
    public String username;
    public String realname;
    public String location;
    public String iconserver;
    public int iconfarm;
    public String path_alias;

    public String getBuddyiconUrl() {
        return String.format("https://farm%s.staticflickr.com/%s/buddyicons/%s.jpg", iconfarm, iconserver, nsid);
    }
}
