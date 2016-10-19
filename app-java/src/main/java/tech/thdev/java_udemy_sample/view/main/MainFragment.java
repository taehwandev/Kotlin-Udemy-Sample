package tech.thdev.java_udemy_sample.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;

/**
 * Created by tae-hwan on 10/5/16.
 */

public class MainFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private SampleAdapter sampleAdapter;

    // static instance 생성
    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        sampleAdapter = new SampleAdapter(getContext());
        recyclerView.setAdapter(sampleAdapter);

        addItems(0, 0);
        sampleAdapter.notifyDataSetChanged();

        // Activity의 {@link FloatingActionButton}
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (sampleAdapter.getItemCount() < 50) {
                    addItems(sampleAdapter.getItemCount(), sampleAdapter.getItemCount());
                    sampleAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void addItems(int size, int count) {
        size = size + 1;
        count = (count / 10) + 1;
        for (int i = size; i < (10 * count); i++) {
            sampleAdapter.addItem(i);
        }
    }
}
