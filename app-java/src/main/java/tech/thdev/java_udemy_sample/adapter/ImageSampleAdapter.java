package tech.thdev.java_udemy_sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.adapter.holder.ImageSampleViewHolder;
import tech.thdev.java_udemy_sample.data.ImageItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageSampleAdapter extends RecyclerView.Adapter<ImageSampleViewHolder> {

    private final Context context;
    private ArrayList<ImageItem> imageItems = new ArrayList<>();

    public ImageSampleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ImageSampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageSampleViewHolder(context, parent);
    }

    @Override
    public void onBindViewHolder(ImageSampleViewHolder holder, int position) {
        holder.onBindView(imageItems.get(position), position);
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    public void addItem(ImageItem imageItem) {
        imageItems.add(imageItem);
    }
}
