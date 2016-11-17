package tech.thdev.java_udemy_sample.view.detail.presenter;

import tech.thdev.base.presenter.AbstractPresenter;
import tech.thdev.java_udemy_sample.data.FlickrPhoto;
import tech.thdev.java_udemy_sample.data.source.photo_detail.PhotoDetailRepository;
import tech.thdev.java_udemy_sample.data.source.photo_detail.PhotoDetailSource;

/**
 * Created by tae-hwan on 11/17/16.
 */

public class DetailMorePresenter extends AbstractPresenter<DetailMoreContract.View>
        implements DetailMoreContract.Presenter {

    private final PhotoDetailRepository photoDetailRepository;

    public DetailMorePresenter(PhotoDetailRepository photoDetailRepository) {
        this.photoDetailRepository = photoDetailRepository;
    }

    @Override
    public void onLoadPhotoInfo(String photoId) {
        photoDetailRepository.getImageItems(photoId, new PhotoDetailSource.LoadImageCallback() {
            @Override
            public void onImageLoaded(FlickrPhoto photo) {
                getView().showPhotoItem(photo);
            }

            @Override
            public void onDataNotAvailable() {
                // do noting.
            }
        });
    }
}
