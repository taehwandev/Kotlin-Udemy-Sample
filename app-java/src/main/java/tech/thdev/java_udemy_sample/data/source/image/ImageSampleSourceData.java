package tech.thdev.java_udemy_sample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.data.ImageItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageSampleSourceData implements ImageSampleSource {

    @Override
    public ArrayList<ImageItem> getImageItems(Context context, int size) {
        ArrayList<ImageItem> imageItems = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String name = String.format("sample_%02d", (int)(Math.random() * 6));
            int resource = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
            imageItems.add(new ImageItem(resource, name));
        }

        return imageItems;
    }
}
