package tech.thdev.java_udemy_sample.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by tae-hwan on 10/5/16.
 */

public class ActivityUtil {

    /**
     * The {@code fragment} is replace to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     **/
    public static void replaceFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }


}
