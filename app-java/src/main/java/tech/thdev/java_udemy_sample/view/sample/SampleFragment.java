package tech.thdev.java_udemy_sample.view.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.adapter.SampleAdapter;
import tech.thdev.java_udemy_sample.data.SampleItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageSampleRepository;
import tech.thdev.java_udemy_sample.databinding.FragmentSampleBinding;
import tech.thdev.java_udemy_sample.view.sample.presenter.SamplePresenter;
import tech.thdev.java_udemy_sample.view.sample.presenter.SamplePresenterImpl;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class SampleFragment extends Fragment implements SamplePresenter.View {

    private FragmentSampleBinding fragmentSampleBinding;

    // MVPPresenter 추가
    private SamplePresenterImpl presenter;

    private SampleAdapter adapter;

    private GridLayoutManager gridLayoutManager;

    // static instance 생성
    public static SampleFragment getInstance() {
        return new SampleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSampleBinding = FragmentSampleBinding.inflate(inflater, container, false);
        return fragmentSampleBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new SamplePresenterImpl(this, ImageSampleRepository.getInstance());

        gridLayoutManager = new GridLayoutManager(getContext(), 1);

        adapter = new SampleAdapter(getContext());

        fragmentSampleBinding.recyclerView.setLayoutManager(gridLayoutManager);
        fragmentSampleBinding.recyclerView.setAdapter(adapter);

        // Activity의 {@link FloatingActionButton}
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.updateImageData(getContext());
            }
        });

        // 새로운 데이터 불러오기
        presenter.updateImageData(getContext());

        fragmentSampleBinding.btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutManager.setSpanCount(1);
                adapter.notifyDataSetChanged();
            }
        });

        fragmentSampleBinding.btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutManager.setSpanCount(2);
                adapter.notifyDataSetChanged();
            }
        });

        fragmentSampleBinding.btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutManager.setSpanCount(3);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addItem(SampleItem imageItem) {
        adapter.addItem(imageItem);
    }
}
