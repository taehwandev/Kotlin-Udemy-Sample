package tech.thdev.java_udemy_sample.view.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import tech.thdev.java_udemy_sample.R;

/**
 * Created by tae-hwan on 10/20/16.
 */

public class MVPAdapter extends RecyclerView.Adapter<MVPAdapter.SampleViewHolder> {

    private Context context;

    // new로 바로 생성
    private ArrayList<Integer> itemList = new ArrayList<>();


    public MVPAdapter(Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new SampleViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        holder.bindView(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * ItemList에 값을 추가한다
     */
    public void addItem(int i) {
        itemList.add(i);
    }

    class SampleViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        SampleViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(context).inflate(R.layout.item_sample, parent, false));

            textView = (TextView) itemView.findViewById(R.id.text);
        }

        void bindView(int index) {
            textView.setText("Index : " + index);
        }
    }
}
