package tech.thdev.java_udemy_sample.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.data.ImageItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageSampleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    public ImageSampleViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false));

        ButterKnife.bind(this, itemView);
    }

    public void onBindView(ImageItem imageItem, int position) {
        imageView.setImageResource(imageItem.getImageRes());
        tvTitle.setText(imageItem.getTitle());
    }
}
