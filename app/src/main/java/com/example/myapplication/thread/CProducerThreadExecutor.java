package com.example.myapplication.thread;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CProducerThreadExecutor {
    private static final String TAG = "mandal_CProducerThreadExecutor";
    private boolean isOdd = true;
    private int mCount = 0;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void runExecutorProgram(){
        executorService.submit(printOddRunnable);
        executorService.submit(printEvenRunnable);
    }

    private final Runnable printOddRunnable = this::printOdd;
    private final Runnable printEvenRunnable = this::printEven;

    private void printOdd(){
        synchronized (this) {
            while (mCount < 10) {
                if (!isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mCount++;
                isOdd = false;
                Log.i(TAG, " " + mCount);
                notify();
            }
        }
    }
    private void printEven(){
        synchronized (this) {
            while (mCount < 10) {
                if (isOdd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mCount++;
                isOdd = true;
                Log.i(TAG, " " + mCount);
                notify();
            }
        }
    }
}
