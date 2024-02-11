package tech.thdev.java_udemy_sample.view.image;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.data.source.image.ImageRepository;
import tech.thdev.java_udemy_sample.databinding.FragmentImageSampleBinding;
import tech.thdev.java_udemy_sample.view.image.adapter.PhotoViewAdapter;
import tech.thdev.java_udemy_sample.view.image.presenter.PhotoViewPresenter;
import tech.thdev.java_udemy_sample.view.image.presenter.PhotoViewPresenterImpl;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewFragment extends Fragment implements PhotoViewPresenter.View {

    private FragmentImageSampleBinding fragmentImageSampleBinding;

    // MVPPresenter 추가
    private PhotoViewPresenterImpl presenter;

    private PhotoViewAdapter adapter;

    // static instance 생성
    public static PhotoViewFragment getInstance() {
        return new PhotoViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentImageSampleBinding = FragmentImageSampleBinding.inflate(inflater, container, false);
        return fragmentImageSampleBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new PhotoViewAdapter(getContext());
        fragmentImageSampleBinding.recyclerView.setAdapter(adapter);

        presenter = new PhotoViewPresenterImpl(this, ImageRepository.getInstance());
        // Activity의 {@link FloatingActionButton}
        presenter = new PhotoViewPresenterImpl(this, ImageRepository.getInstance());

        // Adapter의 View/Model을 셋팅한다
        presenter.setAdapterModel(adapter);
        presenter.setAdapterView(adapter);

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
