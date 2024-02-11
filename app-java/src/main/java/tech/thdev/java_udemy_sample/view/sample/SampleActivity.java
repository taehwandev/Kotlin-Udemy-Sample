package tech.thdev.java_udemy_sample.view.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.databinding.ActivitySampleBinding;
import tech.thdev.java_udemy_sample.util.ActivityUtil;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class SampleActivity extends AppCompatActivity {

    private ActivitySampleBinding activitySampleBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySampleBinding = ActivitySampleBinding.inflate(getLayoutInflater());
        setContentView(activitySampleBinding.getRoot());

        activitySampleBinding.toolbar.setTitle(R.string.app_name);
        setSupportActionBar(activitySampleBinding.toolbar);

        ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), SampleFragment.getInstance(), R.id.frame_layout);
    }
}
