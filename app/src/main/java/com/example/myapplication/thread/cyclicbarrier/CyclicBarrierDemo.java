package com.example.myapplication.thread.cyclicbarrier;

import android.util.Log;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static final String TAG = "mandal_cyclicbarrier";
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public void showNaturalNumbers(){

        //new ThreadTask2().start();
        new ThreadTask().start();
        new ThreadTask2().start();
    }

    public void calculate(){
        for(int i=1;i<=5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAG,"naturalNumber = "+i);
        }
        Log.i(TAG,"main thread complete");
    }

    class ThreadTask2 extends Thread {
        @Override
        public void run() {
            calculate();
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ThreadTask extends Thread {
        @Override
        public void run() {
            try {
                Log.i(TAG,"going to wait");
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAG,"naturalNumber = 10");
        }
    }
}
