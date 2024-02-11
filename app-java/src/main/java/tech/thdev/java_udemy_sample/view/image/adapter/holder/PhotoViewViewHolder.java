package tech.thdev.java_udemy_sample.view.image.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.data.PhotoItem;
import tech.thdev.java_udemy_sample.listener.OnItemClickListener;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    private TextView tvTitle;

    private Context context;

    private OnItemClickListener onItemClickListener;

    public PhotoViewViewHolder(Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;

        imageView = itemView.findViewById(R.id.image);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }

    public void onBindView(PhotoItem photoItem, final int position) {
        tvTitle.setText(photoItem.getTitle());

        Glide.with(context)
                .load(photoItem.getUrl())
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }
}
