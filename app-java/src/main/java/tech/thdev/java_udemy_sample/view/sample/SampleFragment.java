package tech.thdev.java_udemy_sample.view.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.adapter.SampleAdapter;
import tech.thdev.java_udemy_sample.data.SampleItem;
import tech.thdev.java_udemy_sample.data.source.image.ImageSampleRepository;
import tech.thdev.java_udemy_sample.view.sample.presenter.SamplePresenter;
import tech.thdev.java_udemy_sample.view.sample.presenter.SamplePresenterImpl;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class SampleFragment extends Fragment implements SamplePresenter.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        presenter = new SamplePresenterImpl(this, ImageSampleRepository.getInstance());

        gridLayoutManager = new GridLayoutManager(getContext(), 1);

        adapter = new SampleAdapter(getContext());

        recyclerView.setLayoutManager(gridLayoutManager);
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
    public void addItem(SampleItem imageItem) {
        adapter.addItem(imageItem);
    }

    @OnClick(R.id.btn_one)
    public void onClickBtnOne(View view) {
        gridLayoutManager.setSpanCount(1);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_two)
    public void onClickBtnTwo(View view) {
        gridLayoutManager.setSpanCount(2);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_three)
    public void onClickBtnThree(View view) {
        gridLayoutManager.setSpanCount(3);
        adapter.notifyDataSetChanged();
    }
}
