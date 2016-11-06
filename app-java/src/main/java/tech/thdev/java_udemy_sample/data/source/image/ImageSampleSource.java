package tech.thdev.java_udemy_sample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.data.SampleItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public interface ImageSampleSource {

    ArrayList<SampleItem> getImageItems(Context context, int size);
}
