package tech.thdev.java_udemy_sample.view.image.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.data.PhotoItem;
import tech.thdev.java_udemy_sample.listener.OnItemClickListener;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    private Context context;

    private OnItemClickListener onItemClickListener;

    public PhotoViewViewHolder(Context context, ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false));

        this.context = context;
        this.onItemClickListener = onItemClickListener;

        ButterKnife.bind(this, itemView);
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
