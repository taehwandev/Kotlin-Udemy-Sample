package tech.thdev.java_udemy_sample.view.image.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.view.image.adapter.holder.PhotoViewViewHolder;
import tech.thdev.java_udemy_sample.data.PhotoItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewAdapter extends RecyclerView.Adapter<PhotoViewViewHolder> {

    private final Context context;
    private ArrayList<PhotoItem> imageItems = new ArrayList<>();

    public PhotoViewAdapter(Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public PhotoViewViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
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

    public void addItem(PhotoItem imageItem) {
        imageItems.add(imageItem);
    }
}
