package tech.thdev.java_udemy_sample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.data.ImageItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageSampleRepository implements ImageSampleSource {

    private ImageSampleSourceData sampleSourceData;

    private static ImageSampleRepository imageSampleRepository;

    public static ImageSampleRepository getInstance() {
        if (imageSampleRepository == null) {
            imageSampleRepository = new ImageSampleRepository();
        }

        return imageSampleRepository;
    }

    private ImageSampleRepository() {
        sampleSourceData = new ImageSampleSourceData();
    }

    @Override
    public ArrayList<ImageItem> getImageItems(Context context, int size) {
        return sampleSourceData.getImageItems(context, size);
    }
}
