package tech.thdev.java_udemy_sample.view.image.presenter;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.data.ImageItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageSampleRepository;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageSamplePresenterImpl implements ImageSamplePresenter {

    private final View view;
    private final ImageSampleRepository imageSampleRepository;

    public ImageSamplePresenterImpl(View view, ImageSampleRepository imageSampleRepository) {
        this.view = view;
        this.imageSampleRepository = imageSampleRepository;
    }

    @Override
    public void updateImageData(Context context) {
        ArrayList<ImageItem> imageItems = imageSampleRepository.getImageItems(context, 6);
        for (ImageItem imageItem : imageItems) {
            view.addItem(imageItem);
        }

        view.notifyAdapter();
    }

//    @Override
//    public void getItems(int size) {
//        // size를 체크한다. 현재 아이템의 사이즈가 50 보다 작을 동안에만 10개씩 추가한다
//        if (size < 50) {
//            size = size + 1;
//            int count = (size / 10) + 1;
//            for (int i = size; i < (10 * count); i++) {
//                // Adapter에 아이템을 add 한다
//                view.addItem(i);
//            }
//
//            // View의 Adapter를 갱신한다
//            view.adapterNotify();
//        }
//    }
}
