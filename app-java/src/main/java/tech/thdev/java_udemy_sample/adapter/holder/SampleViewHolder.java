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
import tech.thdev.java_udemy_sample.data.SampleItem;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class SampleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    public SampleViewHolder(Context context, ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_text_view, parent, false));

        ButterKnife.bind(this, itemView);
    }

    public void onBindView(SampleItem imageItem, int position) {
        imageView.setImageResource(imageItem.getImageRes());
        tvTitle.setText(imageItem.getTitle());
    }
}
