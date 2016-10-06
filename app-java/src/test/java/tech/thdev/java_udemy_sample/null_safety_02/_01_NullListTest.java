package tech.thdev.java_udemy_sample.null_safety_02;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tae-hwan on 10/7/16.
 */

public class _01_NullListTest {

    @Test
    public void testList() throws InterruptedException {
        List<String> itemList = new ArrayList<>();
        itemList.add("A");
        itemList.add(null);
        itemList.add("B");

        for (String text : itemList) {
            if (text != null) {
                System.out.println("Text : " + text);
            }
        }
    }
}
