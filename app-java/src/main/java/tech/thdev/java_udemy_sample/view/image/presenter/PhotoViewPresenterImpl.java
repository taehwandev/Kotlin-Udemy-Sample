package tech.thdev.java_udemy_sample.view.image.presenter;

import java.util.List;

import tech.thdev.java_udemy_sample.data.PhotoItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageRepository;
import tech.thdev.java_udemy_sample.data.source.image.ImageSource;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewPresenterImpl implements PhotoViewPresenter {

    private final View view;
    private final ImageRepository imageSampleRepository;

    private int page = -1;

    public PhotoViewPresenterImpl(View view, ImageRepository imageSampleRepository) {
        this.view = view;
        this.imageSampleRepository = imageSampleRepository;

        page = -1;
    }

    @Override
    public void recentPhotoData() {
        imageSampleRepository.getImageItems(++page, new ImageSource.LoadImageCallback() {
            @Override
            public void onImageLoaded(List<PhotoItem> photoItems) {
                view.showLoaded();
            }

            @Override
            public void onDataNotAvailable() {
                view.showFailLoaded();
            }
        });
    }
}
