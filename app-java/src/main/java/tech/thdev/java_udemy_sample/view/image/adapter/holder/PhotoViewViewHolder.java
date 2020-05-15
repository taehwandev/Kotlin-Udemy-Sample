package tech.thdev.java_udemy_sample.view.image.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.data.PhotoItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    private Context context;

    public PhotoViewViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false));

        this.context = context;

        ButterKnife.bind(this, itemView);
    }

    public void onBindView(PhotoItem photoItem, int position) {
        tvTitle.setText(photoItem.getTitle());

        Glide.with(context)
                .load(photoItem.getUrl())
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(imageView);
    }
}
