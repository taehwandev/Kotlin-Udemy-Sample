package tech.thdev.java_udemy_sample.view.detail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import tech.thdev.base.view.BasePresenterActivity;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.data.FlickrPhoto;
import tech.thdev.java_udemy_sample.data.source.photo_detail.PhotoDetailRepository;
import tech.thdev.java_udemy_sample.view.detail.presenter.DetailMoreContract;
import tech.thdev.java_udemy_sample.view.detail.presenter.DetailMorePresenter;

/**
 * Created by tae-hwan on 11/17/16.
 */

public class DetailMoreActivity extends BasePresenterActivity<DetailMoreContract.View, DetailMoreContract.Presenter>
        implements DetailMoreContract.View {

    public static final String KEY_PHOTO_ID = "photoId";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.img_view)
    ImageView imgView;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public DetailMoreContract.Presenter onCreatePresenter() {
        return new DetailMorePresenter(PhotoDetailRepository.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_more);

        setSupportActionBar(toolbar);

        String photoId = getIntent().getStringExtra(KEY_PHOTO_ID);
        getPresenter().onLoadPhotoInfo(photoId);
    }

    @Override
    public void showPhotoItem(FlickrPhoto photo) {
        Glide.with(this).load(photo.getUrl())
                .placeholder(0)
                .fitCenter()
                .crossFade()
                .into(imgView);

        setTitle(photo.owner.username);

        tvTitle.setText(photo.title._content);
        tvContent.setText(photo.description._content);
    }
}
