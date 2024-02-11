package tech.thdev.java_udemy_sample.view.mvp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.util.ActivityUtil;

public class MVPActivity extends AppCompatActivity {

    private tech.thdev.java_udemy_sample.databinding.ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = tech.thdev.java_udemy_sample.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.toolbar.setTitle(R.string.app_name);
        setSupportActionBar(activityMainBinding.toolbar);

        ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), MVPFragment.getInstance(), R.id.frame_layout);
    }
}
