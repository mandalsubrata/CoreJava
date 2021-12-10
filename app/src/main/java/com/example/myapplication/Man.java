package com.example.myapplication;

import android.util.Log;

public class Man extends AbstractClass implements hand{
    private static final String TAG = "mandal_Man";

    @Override
    public void showHand() {
        Log.i(TAG,"shoeHand");
    }

    @Override
    public int age() {
        Log.i(TAG,"age is : 30");
        return 30;
    }
}
