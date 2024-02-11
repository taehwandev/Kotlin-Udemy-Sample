package tech.thdev.java_udemy_sample.view.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import tech.thdev.java_udemy_sample.R;
import tech.thdev.java_udemy_sample.databinding.ActivityMainBinding;
import tech.thdev.java_udemy_sample.util.ActivityUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.toolbar.setTitle(R.string.app_name);
        setSupportActionBar(activityMainBinding.toolbar);

        ActivityUtil.replaceFragmentToActivity(getSupportFragmentManager(), MainFragment.getInstance(), R.id.frame_layout);
    }
}
