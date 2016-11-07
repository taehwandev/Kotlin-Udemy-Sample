package tech.thdev.java_udemy_sample.data.source.image;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.thdev.java_udemy_sample.data.PhotoResponse;
import tech.thdev.java_udemy_sample.network.FlickrService;
import tech.thdev.java_udemy_sample.network.RetrofitCreator;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageRemoteDataSource implements ImageSource {

    private static ImageRemoteDataSource INSTANCE;

    private final FlickrService flickrService;

    private ImageRemoteDataSource() {
        flickrService = RetrofitCreator.createRetrofit().create(FlickrService.class);
    }

    public static ImageRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImageRemoteDataSource();
        }

        return INSTANCE;
    }

    @Override
    public void getImageItems(int page, final LoadImageCallback loadImageCallback) {
        flickrService.getFlickrRecentPhotos(page)
                .enqueue(new Callback<PhotoResponse>() {
                    @Override
                    public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                        if (!response.isSuccessful()) {
                            if (loadImageCallback != null) {
                                loadImageCallback.onDataNotAvailable();
                            }
                            return;
                        }

                        Log.d("TAG", "response raw " + response.raw());

                        // Body를 불러온다. 이 때 이미 GSON에서 변환된 이후이다.
                        PhotoResponse photoResponse = response.body();
                        if (photoResponse != null) {
                            if (photoResponse.getCode() == 200 && photoResponse.getPhotoPageInfo() != null) {
                                loadImageCallback.onImageLoaded(photoResponse.getPhotoPageInfo().getPhotoList());

                            } else {
                                loadImageCallback.onLoadFail(photoResponse.getCode(), photoResponse.getMessage());
                            }

                        } else {
                            loadImageCallback.onDataNotAvailable();
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotoResponse> call, Throwable t) {
                        if (loadImageCallback != null) {
                            loadImageCallback.onDataNotAvailable();
                        }
                    }
                });
    }
}
