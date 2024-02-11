package tech.thdev.java_udemy_sample.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.databinding.FragmentMainBinding;

/**
 * Created by tae-hwan on 10/5/16.
 */

public class MainFragment extends Fragment {

    private SampleAdapter sampleAdapter;

    private FragmentMainBinding fragmentMainBinding;

    // static instance 생성
    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        return fragmentMainBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sampleAdapter = new SampleAdapter(getContext());
        fragmentMainBinding.recyclerView.setAdapter(sampleAdapter);

        addItems(0);
        sampleAdapter.notifyDataSetChanged();

        // Activity의 {@link FloatingActionButton}
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (sampleAdapter.getItemCount() < 50) {
                    addItems(sampleAdapter.getItemCount());
                    sampleAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void addItems(int size) {
        size = size + 1;
        int count = (size / 10) + 1;
        for (int i = size; i < (10 * count); i++) {
            sampleAdapter.addItem(i);
        }
    }
}
