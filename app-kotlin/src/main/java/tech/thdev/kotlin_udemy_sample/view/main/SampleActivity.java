package tech.thdev.kotlin_udemy_sample.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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

        ActivityUtilKt.replaceFragmentToActivity(this, MainFragment.Companion.getInstance(), R.layout.activity_main);
    }
}
