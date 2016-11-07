package tech.thdev.java_udemy_sample.view.image;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.adapter.PhotoViewAdapter;
import tech.thdev.java_udemy_sample.data.source.image.ImageRepository;
import tech.thdev.java_udemy_sample.view.image.presenter.PhotoViewPresenter;
import tech.thdev.java_udemy_sample.view.image.presenter.PhotoViewPresenterImpl;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewFragment extends Fragment implements PhotoViewPresenter.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    // MVPPresenter 추가
    private PhotoViewPresenterImpl presenter;

    private PhotoViewAdapter adapter;

    // static instance 생성
    public static PhotoViewFragment getInstance() {
        return new PhotoViewFragment();
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

        presenter = new PhotoViewPresenterImpl(this, ImageRepository.getInstance());

        adapter = new PhotoViewAdapter(getContext());
        recyclerView.setAdapter(adapter);

        // Activity의 {@link FloatingActionButton}
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.recentPhotoData();
            }
        });

        // 새로운 데이터 불러오기
        presenter.recentPhotoData();
    }

    @Override
    public void showLoaded() {
        Toast.makeText(getContext(), "Load success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailLoaded() {
        Toast.makeText(getContext(), "Load fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadFailMessage(int code, String message) {
        Toast.makeText(getContext(), "Code " + code + ", message " + message, Toast.LENGTH_LONG).show();
        Log.e("TAG", "Code " + code + ", message " + message);
    }
}
