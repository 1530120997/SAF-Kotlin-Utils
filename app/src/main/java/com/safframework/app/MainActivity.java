package com.safframework.app;

import android.app.Activity;
import android.os.Bundle;

import com.safframework.log.L;
import com.safframework.utils.AppUtils;

/**
 * Created by tony on 2017/2/26.
 */

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        L.i("可用内存："+AppUtils.getDeviceUsableMemory(this));
        L.i("sdk版本："+AppUtils.getSDKVersion());
    }
}