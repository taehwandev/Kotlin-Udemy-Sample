package tech.thdev.java_udemy_sample.adapter.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.data.SampleItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class SampleViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    private TextView tvTitle;

    public SampleViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_text_view, parent, false));

        imageView = itemView.findViewById(R.id.image);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }

    public void onBindView(SampleItem imageItem, int position) {
        imageView.setImageResource(imageItem.getImageRes());
        tvTitle.setText(imageItem.getTitle());
    }
}
