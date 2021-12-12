package com.example.myapplication.thread;

import android.util.Log;

public class ThreadClass {
    private static final String TAG = "mandal_Thread";
    private boolean isOdd = true;
    private int count = 0;

    Thread evenThread = new Thread(()->{
        synchronized (this){
            while (count < 20) {
                Log.i(TAG,"Even method while");
                if (isOdd) {
                    try {
                        Log.i(TAG,"Even method wait");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isOdd = false;
                count++;
                Log.i(TAG, "Even print " + count);
                notify();
            }
        }
    });

    Thread oddThread = new Thread(()->{
        synchronized (this){
            while (count < 20) {
                Log.i(TAG,"odd method while");
                if (!isOdd) {
                    try {
                        Log.i(TAG,"odd method wait");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                isOdd = true;
                count++;
                Log.i(TAG, " Odd print" + count);
                notify();
            }
        }
    });

    public void showNaturalNumber(){
        evenThread.start();
        oddThread.start();
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
