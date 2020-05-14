package tech.thdev.kotlin_udemy_sample.view.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import tech.thdev.kotlin_udemy_sample.R;
import tech.thdev.kotlin_udemy_sample.util.ActivityUtilKt;

/**
 * Created by tae-hwan on 10/6/16.
 *
 * 다음은 코틀린을 Java에서 사용하는 경우에 해당됩니다.
 */

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActivityUtilKt.replaceFragmentToActivity(this, MainFragment.Companion.getInstance(), R.layout.activity_main);
    }
}
