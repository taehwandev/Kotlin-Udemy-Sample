package tech.thdev.java_udemy_sample.view.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.util.ActivityUtil;

/**
 * Created by tae-hwan on 10/29/16.
 */

public class SampleActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        // ButterKnife 사용
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), SampleFragment.getInstance(), R.id.frame_layout);
    }
}
