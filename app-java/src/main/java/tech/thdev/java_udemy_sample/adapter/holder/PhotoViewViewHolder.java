package tech.thdev.java_udemy_sample.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.async.ImageDownloadThread;
import tech.thdev.java_udemy_sample.data.PhotoItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    public PhotoViewViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false));

        ButterKnife.bind(this, itemView);
    }

    public void onBindView(PhotoItem photoItem, int position) {
        tvTitle.setText(photoItem.getTitle());
        ImageDownloadThread.getInstance().loadImage(R.drawable.loading, imageView, photoItem.getUrl());
    }
}
