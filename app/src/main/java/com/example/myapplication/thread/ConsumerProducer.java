package com.example.myapplication.thread;

import android.util.Log;

public class ConsumerProducer {
    private static final String TAG = "mandal_ConsumerProducer";
    public int count = 0;
    public boolean isProduced;

    public void ConsumeAndProduce(){
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Thread consumer = new Thread(()->{
        synchronized (this){
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
    });
    Thread producer = new Thread(()->{
        synchronized (this){
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
    });
}
