package tech.thdev.java_udemy_sample.view.mvp;

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
import tech.thdev.java_udemy_sample.view.mvp.presenter.MVPPresenter;
import tech.thdev.java_udemy_sample.view.mvp.presenter.MVPImpl;

/**
 * Created by tae-hwan on 10/5/16.
 */

public class MVPFragment extends Fragment implements MVPPresenter.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    // MVPPresenter 추가
    private MVPPresenter mvpPresenter;

    private MVPAdapter mvpAdapter;

    // static instance 생성
    public static MVPFragment getInstance() {
        return new MVPFragment();
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

        mvpPresenter = new MVPImpl(this);

        mvpAdapter = new MVPAdapter(getContext());
        recyclerView.setAdapter(mvpAdapter);

        mvpPresenter.getItems(0);
        mvpAdapter.notifyDataSetChanged();

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
