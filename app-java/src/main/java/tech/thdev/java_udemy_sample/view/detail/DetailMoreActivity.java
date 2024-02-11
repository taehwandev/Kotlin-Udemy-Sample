package tech.thdev.java_udemy_sample.view.detail;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.base.ui.BasePresenterActivity;

import org.jetbrains.annotations.NotNull;

import tech.thdev.java_udemy_sample.data.FlickrPhoto;
import tech.thdev.java_udemy_sample.data.source.photo_detail.PhotoDetailRepository;
import tech.thdev.java_udemy_sample.databinding.ActivityDetailMoreBinding;
import tech.thdev.java_udemy_sample.view.detail.presenter.DetailMoreContract;
import tech.thdev.java_udemy_sample.view.detail.presenter.DetailMorePresenter;

/**
 * Created by tae-hwan on 11/17/16.
 */

public class DetailMoreActivity extends BasePresenterActivity<DetailMoreContract.View, DetailMoreContract.Presenter>
        implements DetailMoreContract.View {

    public static final String KEY_PHOTO_ID = "photoId";

    private ActivityDetailMoreBinding activityDetailMoreBinding;

    @NotNull
    @Override
    public DetailMoreContract.Presenter onCreatePresenter() {
        return new DetailMorePresenter(PhotoDetailRepository.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailMoreBinding = ActivityDetailMoreBinding.inflate(getLayoutInflater());
        setContentView(activityDetailMoreBinding.getRoot());

        setSupportActionBar(activityDetailMoreBinding.toolbar);
        setTitle("");

        String photoId = getIntent().getStringExtra(KEY_PHOTO_ID);
        getPresenter().onLoadPhotoInfo(photoId);
    }

    @Override
    public void showPhotoItem(FlickrPhoto photo) {
        Glide.with(this).load(photo.getUrl())
                .placeholder(0)
                .fitCenter()
                .into(activityDetailMoreBinding.imgView);

        setTitle(photo.owner.username);

        activityDetailMoreBinding.rlSheetView.tvTitle.setText(photo.title._content);
        activityDetailMoreBinding.rlSheetView.tvContent.setText(photo.description._content);
    }
}
