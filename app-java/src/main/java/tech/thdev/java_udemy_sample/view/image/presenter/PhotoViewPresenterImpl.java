package tech.thdev.java_udemy_sample.view.image.presenter;

import java.util.List;

import tech.thdev.java_udemy_sample.listener.OnItemClickListener;
import tech.thdev.java_udemy_sample.view.image.adapter.model.PhotoViewAdapterContract;
import tech.thdev.java_udemy_sample.data.PhotoItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageRepository;
import tech.thdev.java_udemy_sample.data.source.image.ImageSource;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewPresenterImpl implements PhotoViewPresenter, OnItemClickListener {

    private final View view;
    private final ImageRepository imageSampleRepository;

    private PhotoViewAdapterContract.Model adapterModel;
    private PhotoViewAdapterContract.View adapterView;

    private int page = 0;

    public PhotoViewPresenterImpl(View view, ImageRepository imageSampleRepository) {
        this.view = view;
        this.imageSampleRepository = imageSampleRepository;

        page = 0;
    }

    @Override
    public void setAdapterModel(PhotoViewAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setAdapterView(PhotoViewAdapterContract.View adapterView) {
        this.adapterView = adapterView;
        this.adapterView.setOnItemClickListener(this);
    }

    @Override
    public void recentPhotoData() {
        imageSampleRepository.getImageItems(++page, new ImageSource.LoadImageCallback() {
            @Override
            public void onImageLoaded(List<PhotoItem> photoItems) {
                if (adapterModel != null && adapterView != null) {
                    for (PhotoItem photoItem : photoItems) {
                        adapterModel.addItem(photoItem);
                    }

                    adapterView.onReload();
                }
                view.showLoaded();
            }

            @Override
            public void onDataNotAvailable() {
                view.showFailLoaded();
            }

            @Override
            public void onLoadFail(int code, String message) {
                view.showLoadFailMessage(code, message);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        PhotoItem photoItem = adapterModel.getItem(position);
        view.showDetailPage(photoItem);
    }
}
