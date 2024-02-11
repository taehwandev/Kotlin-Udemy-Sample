package tech.thdev.java_udemy_sample.view.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

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

        setSupportActionBar(activityMainBinding.toolbar);

        // static Util을 이용하여 replace 처리
        ActivityUtil
                .replaceFragmentToActivity(
                        getSupportFragmentManager(),
                        MainFragment.getInstance(),
                        R.id.frame_layout);

        activityMainBinding.fab.setOnClickListener(view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
        );
    }
}
