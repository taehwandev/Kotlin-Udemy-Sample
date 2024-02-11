package tech.thdev.java_udemy_sample.view.image;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.adapter.ImageSampleAdapter;
import tech.thdev.java_udemy_sample.data.ImageItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageSampleRepository;
import tech.thdev.java_udemy_sample.databinding.FragmentImageSampleBinding;
import tech.thdev.java_udemy_sample.view.image.presenter.ImageSamplePresenter;
import tech.thdev.java_udemy_sample.view.image.presenter.ImageSamplePresenterImpl;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageSampleFragment extends Fragment implements ImageSamplePresenter.View {

    private FragmentImageSampleBinding fragmentImageSampleBinding;

    // MVPPresenter 추가
    private ImageSamplePresenterImpl presenter;

    private ImageSampleAdapter adapter;

    // static instance 생성
    public static ImageSampleFragment getInstance() {
        return new ImageSampleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentImageSampleBinding = FragmentImageSampleBinding.inflate(inflater, container, false);
        return fragmentImageSampleBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new ImageSamplePresenterImpl(this, ImageSampleRepository.getInstance());

        adapter = new ImageSampleAdapter(getContext());
        fragmentImageSampleBinding.recyclerView.setAdapter(adapter);

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
    }

    @Override
    public void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addItem(ImageItem imageItem) {
        adapter.addItem(imageItem);
    }
}
