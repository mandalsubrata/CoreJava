package com.example.myapplication;

import android.util.Log;

public class ConsumerProducer {
    private static final String TAG = "mandal_ConsumerProducer";
    public int count = 0;
    public boolean isProduced;


    public synchronized void consume() {
       Log.i(TAG,">>>>>>>>>>"+ Thread.currentThread().getThreadGroup().getParent().getName());
        while (count < 10) {

            if (!isProduced) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isProduced = false;
            Log.i(TAG, "Consumed value: " + count);
            notify();
        }
    }

    public synchronized void produce() {
        while (count < 10) {

            if (isProduced) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            isProduced = true;
            Log.i(TAG, " Produced : " + count);
            notify();
        }
    }

    public class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }
    }
    public class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }
    }
    public void ConsumeAndProduce(){
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
