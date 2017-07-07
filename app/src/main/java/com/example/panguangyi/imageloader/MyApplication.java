package com.example.panguangyi.imageloader;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/7/7.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
