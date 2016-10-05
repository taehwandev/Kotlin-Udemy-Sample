package tech.thdev.java_udemy_sample.view.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.java_udemy_sample.R;

/**
 * Created by tae-hwan on 10/5/16.
 */

public class MainFragment extends Fragment {

    @BindView(R.id.number_one)
    EditText etNumberOne;

    @BindView(R.id.number_two)
    EditText etNumberTwo;

    // static instance 생성
    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        final TextView textView = (TextView) view.findViewById(R.id.text);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getSum() + "");
            }
        });
    }

    /**
     * 입력 받은 2개의 수를 더하여 return
     * <p>
     * 오류가 있습니다. 디버깅하여 수정하세요.
     */
    private int getSum() {
        int oneNumber = Integer.parseInt(etNumberOne.getText().toString());
        String two = etNumberTwo.getText().toString();
        if (!TextUtils.isEmpty(two)) {
            int twoNumber = Integer.parseInt(two);

            return oneNumber + twoNumber;
        }
        return 0;
    }
}
