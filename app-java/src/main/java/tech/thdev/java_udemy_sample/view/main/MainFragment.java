package tech.thdev.java_udemy_sample.view.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import tech.thdev.java_udemy_sample.databinding.FragmentMainBinding;

/**
 * Created by tae-hwan on 10/5/16.
 */

public class MainFragment extends Fragment {

    private FragmentMainBinding fragmentMainBinding;

    // static instance 생성
    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        return fragmentMainBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMainBinding.text.setText(String.format(Locale.getDefault(), "%d", getSum()));
            }
        });
    }

    /**
     * 입력 받은 2개의 수를 더하여 return
     * <p>
     * 오류가 있습니다. 디버깅하여 수정하세요.
     */
    private int getSum() {
        int oneNumber = Integer.parseInt(fragmentMainBinding.numberOne.getText().toString());
        String two = fragmentMainBinding.numberTwo.getText().toString();
        if (!TextUtils.isEmpty(two)) {
            int twoNumber = Integer.parseInt(two);

            return oneNumber + twoNumber;
        }
        return 0;
    }
}
