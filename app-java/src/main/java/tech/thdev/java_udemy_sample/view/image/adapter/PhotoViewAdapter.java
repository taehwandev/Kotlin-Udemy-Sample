package tech.thdev.java_udemy_sample.view.image.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.data.PhotoItem;
import tech.thdev.java_udemy_sample.listener.OnItemClickListener;
import tech.thdev.java_udemy_sample.view.image.adapter.holder.PhotoViewViewHolder;
import tech.thdev.java_udemy_sample.view.image.adapter.model.PhotoViewAdapterContract;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewAdapter extends RecyclerView.Adapter<PhotoViewViewHolder>
        implements PhotoViewAdapterContract.Model, PhotoViewAdapterContract.View {

    private final Context context;
    private ArrayList<PhotoItem> imageItems = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public PhotoViewAdapter(Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public PhotoViewViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new PhotoViewViewHolder(context, parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(PhotoViewViewHolder holder, int position) {
        holder.onBindView(getItem(position), position);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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
    public PhotoItem getItem(int position) {
        return imageItems.get(position);
    }

    @Override
    public void onReload() {
        notifyDataSetChanged();
    }
}
