package tech.thdev.java_udemy_sample.view.image.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.view.image.adapter.model.PhotoViewAdapterContract;
import tech.thdev.java_udemy_sample.view.image.adapter.holder.PhotoViewViewHolder;
import tech.thdev.java_udemy_sample.data.PhotoItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewAdapter extends RecyclerView.Adapter<PhotoViewViewHolder>
        implements PhotoViewAdapterContract.Model, PhotoViewAdapterContract.View {

    private final Context context;
    private ArrayList<PhotoItem> imageItems = new ArrayList<>();

    public PhotoViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PhotoViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoViewViewHolder(context, parent);
    }

    @Override
    public void onBindViewHolder(PhotoViewViewHolder holder, int position) {
        holder.onBindView(imageItems.get(position), position);
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    @Override
    public void addItem(PhotoItem item) {
        imageItems.add(item);
    }

    @Override
    public void onReload() {
        notifyDataSetChanged();
    }
}
