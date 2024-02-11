package tech.thdev.java_udemy_sample.view.image;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.databinding.ActivityImageSampleBinding;
import tech.thdev.java_udemy_sample.util.ActivityUtil;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class PhotoViewActivity extends AppCompatActivity {

    private ActivityImageSampleBinding activityImageSampleBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityImageSampleBinding = ActivityImageSampleBinding.inflate(getLayoutInflater());
        setContentView(activityImageSampleBinding.getRoot());

        activityImageSampleBinding.toolbar.setTitle(R.string.app_name);
        setSupportActionBar(activityImageSampleBinding.toolbar);

        ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), PhotoViewFragment.getInstance(), R.id.frame_layout);
    }
}
