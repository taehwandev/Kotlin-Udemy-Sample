package tech.thdev.java_udemy_sample.network;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tech.thdev.java_udemy_sample.BuildConfig;
import tech.thdev.java_udemy_sample.data.FlickrInfo;
import tech.thdev.java_udemy_sample.data.PhotoResponse;

/**
 * Created by tae-hwan on 11/7/16.
 */

public interface FlickrService {

    /**
     * 최근 검색
     * <a href="https://www.flickr.com/services/api/explore/flickr.interestingness.getList">최근 목록 불러오기</a>
     */
    @POST("?method=flickr.interestingness.getList&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    Call<PhotoResponse> getFlickrRecentPhotos(@Query("page") int page);

    // https://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=0bde4e6810b2f5295df2270bc9ceda8e&photo_id=30930664135&format=json&nojsoncallback=1
    @POST("?method=flickr.photos.getInfo&format=json&nojsoncallback=1&api_key=" + BuildConfig.FLICKR_API_KEY)
    Call<FlickrInfo> getPhotoInfo(@Query("photo_id") String photoId);
}
