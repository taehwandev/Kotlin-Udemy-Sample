package tech.thdev.java_udemy_sample.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tae-hwan on 11/7/16.
 */

public class PhotoPageInfo {

    private int page;
    private int pages;

    @SerializedName("perpage")
    private int perPage;
    private int total;

    @SerializedName("photo")
    private List<PhotoItem> photoList;
    private String stat;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getperPage() {
        return perPage;
    }

    public void setperPage(int perpage) {
        this.perPage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PhotoItem> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoItem> photoList) {
        this.photoList = photoList;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
