package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.thread.ConsumerProducer;
import com.example.myapplication.thread.ThreadClass;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mandal_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThreadClass thread = new ThreadClass();
        thread.showNaturalNumber();

        ConsumerProducer consumerProducer = new ConsumerProducer();
        consumerProducer.ConsumeAndProduce();
    }
}