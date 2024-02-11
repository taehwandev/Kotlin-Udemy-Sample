package tech.thdev.java_udemy_sample.view.mvp;

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
import tech.thdev.java_udemy_sample.view.mvp.presenter.MVPPresenter;
import tech.thdev.java_udemy_sample.view.mvp.presenter.MVPPresenterImpl;

/**
 * Created by tae-hwan on 10/5/16.
 */

public class MVPFragment extends Fragment implements MVPPresenter.View {

    // MVPPresenter 추가
    private MVPPresenter mvpPresenter;

    private FragmentMainBinding fragmentMainBinding;

    private MVPAdapter mvpAdapter;

    // static instance 생성
    public static MVPFragment getInstance() {
        return new MVPFragment();
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

        mvpPresenter = new MVPPresenterImpl(this);

        mvpAdapter = new MVPAdapter(getContext());
        fragmentMainBinding.recyclerView.setAdapter(mvpAdapter);

        mvpPresenter.getItems(0);

        // Activity의 {@link FloatingActionButton}
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mvpPresenter.getItems(mvpAdapter.getItemCount());
            }
        });
    }

    @Override
    public void addItem(int index) {
        mvpAdapter.addItem(index);
    }

    @Override
    public void adapterNotify() {
        mvpAdapter.notifyDataSetChanged();
    }
}
