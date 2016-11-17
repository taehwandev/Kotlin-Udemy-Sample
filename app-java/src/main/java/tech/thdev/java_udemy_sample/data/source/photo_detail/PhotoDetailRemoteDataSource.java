package tech.thdev.java_udemy_sample.data.source.photo_detail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.thdev.java_udemy_sample.data.FlickrInfo;
import tech.thdev.java_udemy_sample.network.FlickrService;
import tech.thdev.java_udemy_sample.network.RetrofitCreator;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoDetailRemoteDataSource implements PhotoDetailSource {

    private static PhotoDetailRemoteDataSource INSTANCE;

    private final FlickrService flickrService;

    private PhotoDetailRemoteDataSource() {
        flickrService = RetrofitCreator.createRetrofit().create(FlickrService.class);
    }

    public static PhotoDetailRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PhotoDetailRemoteDataSource();
        }

        return INSTANCE;
    }

    @Override
    public void getImageItems(String photoId, final LoadImageCallback loadImageCallback) {
        flickrService.getPhotoInfo(photoId)
                .enqueue(new Callback<FlickrInfo>() {
                    @Override
                    public void onResponse(Call<FlickrInfo> call, Response<FlickrInfo> response) {
                        if (!response.isSuccessful()) {
                            if (loadImageCallback != null) {
                                loadImageCallback.onDataNotAvailable();
                            }
                            return;
                        }

                        // Body를 불러온다. 이 때 이미 GSON에서 변환된 이후이다.
                        FlickrInfo photoResponse = response.body();
                        if (photoResponse != null && photoResponse.stat.equals("ok") && photoResponse.photo != null) {
                            loadImageCallback.onImageLoaded(photoResponse.photo);

                        } else {
                            loadImageCallback.onDataNotAvailable();
                        }
                    }

                    @Override
                    public void onFailure(Call<FlickrInfo> call, Throwable t) {
                        if (loadImageCallback != null) {
                            loadImageCallback.onDataNotAvailable();
                        }
                    }
                });
    }
}
