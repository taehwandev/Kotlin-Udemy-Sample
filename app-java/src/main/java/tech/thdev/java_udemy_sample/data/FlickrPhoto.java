package tech.thdev.java_udemy_sample.data;

/**
 * Created by tae-hwan on 11/17/16.
 */

public class FlickrPhoto {
    public String id;
    public String secret;
    public String server;
    public int farm;
    public String dateuploaded;
    public FlickrOwner owner;
    public FlickrContent title;
    public FlickrContent description;
    public FlickrDates dates;
    public FlickrContent comments;
    public String views;
    public FlickrUrls urls;
    public String media;

    /**
     * API : <a href="https://www.flickr.com/services/api/misc.urls.html">Photo source url</a>
     * https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
     */
    public String getUrl() {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s.jpg", farm, server, id, secret);
    }
}
