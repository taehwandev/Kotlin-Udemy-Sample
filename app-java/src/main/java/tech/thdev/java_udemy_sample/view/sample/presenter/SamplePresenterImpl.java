package tech.thdev.java_udemy_sample.view.sample.presenter;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.data.SampleItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageSampleRepository;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class SamplePresenterImpl implements SamplePresenter {

    private final View view;
    private final ImageSampleRepository imageSampleRepository;

    public SamplePresenterImpl(View view, ImageSampleRepository imageSampleRepository) {
        this.view = view;
        this.imageSampleRepository = imageSampleRepository;
    }

    @Override
    public void updateImageData(Context context) {
        ArrayList<SampleItem> imageItems = imageSampleRepository.getImageItems(context, 6);
        for (SampleItem imageItem : imageItems) {
            view.addItem(imageItem);
        }

        view.notifyAdapter();
    }