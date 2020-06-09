package com.example.navigationdemo;

import android.app.Activity;
import android.app.Application;

import com.jaeger.library.StatusBarUtil;

public class MyApplication extends Application {
    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
}
