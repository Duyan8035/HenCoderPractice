package com.example.administrator.hencoderpractice;

import android.annotation.SuppressLint;
import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * @author Administrator
 * @date 2017/11/7
 */
@SuppressLint("Registered")
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);

    }
}
