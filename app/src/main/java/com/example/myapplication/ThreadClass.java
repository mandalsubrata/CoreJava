package com.example.myapplication;

import android.util.Log;

public class ThreadClass {
    private static final String TAG = "mandal_Thread";
    private boolean isOdd = true;
    private int count = 0;

    public synchronized void even()  {
        Log.i(TAG,"Even method called");
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

    public synchronized void odd() {
        Log.i(TAG,"odd method called");
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

    public class EvenThread extends java.lang.Thread {
        @Override
        public void run() {
           even();

        }
    }
    public class OddThread extends java.lang.Thread {
        @Override
        public void run() {
           odd();

        }
    }
    public void showNaturalNumber(){
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
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
