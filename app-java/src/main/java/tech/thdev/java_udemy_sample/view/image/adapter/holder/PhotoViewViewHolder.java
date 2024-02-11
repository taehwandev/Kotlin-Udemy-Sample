package tech.thdev.java_udemy_sample.view.image.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.async.ImageDownloadThread;
import tech.thdev.java_udemy_sample.data.PhotoItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    private TextView tvTitle;

    public PhotoViewViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false));

        imageView = itemView.findViewById(R.id.image);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }

    public void onBindView(PhotoItem photoItem, int position) {
        tvTitle.setText(photoItem.getTitle());
        ImageDownloadThread.getInstance().loadImage(R.drawable.loading, imageView, photoItem.getUrl());
    }
}
