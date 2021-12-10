package com.example.myapplication;

import android.util.Log;

public abstract class AbstractClass {
    private static final String TAG = "mandal_AbstractClass";
    public abstract int age();
    public void test(){
        Log.i(TAG,"test from abstract class");
    }
}
