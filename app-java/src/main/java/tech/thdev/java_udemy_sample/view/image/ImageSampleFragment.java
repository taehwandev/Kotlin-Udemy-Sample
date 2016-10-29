package tech.thdev.java_udemy_sample.view.image;

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
import tech.thdev.java_udemy_sample.adapter.ImageSampleAdapter;
import tech.thdev.java_udemy_sample.data.ImageItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageSampleRepository;
import tech.thdev.java_udemy_sample.view.image.presenter.ImageSamplePresenter;
import tech.thdev.java_udemy_sample.view.image.presenter.ImageSamplePresenterImpl;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class ImageSampleFragment extends Fragment implements ImageSamplePresenter.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

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
        return inflater.inflate(R.layout.fragment_image_sample, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        presenter = new ImageSamplePresenterImpl(this, ImageSampleRepository.getInstance());

        adapter = new ImageSampleAdapter(getContext());
        recyclerView.setAdapter(adapter);

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
