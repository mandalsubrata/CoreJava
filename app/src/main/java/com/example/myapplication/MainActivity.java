package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.integer.IntegerClass;
import com.example.myapplication.string.StringPrograms;
import com.example.myapplication.thread.ConsumerProducer;
import com.example.myapplication.thread.ThreadClass;
import com.example.myapplication.thread.cyclicbarrier.CyclicBarrierDemo;

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

        StringPrograms stringPrograms = new StringPrograms();
        int totalCountOfChar = stringPrograms.countCharInString();
        Log.i(TAG, "totalCountOfChar: " + totalCountOfChar);

        IntegerClass integerClass = new IntegerClass();
        integerClass.printAllDigitsInInteger(1728393749);

        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        cyclicBarrierDemo.showNaturalNumbers();

        MethodOverloading methodOverloading = new MethodOverloading();
        methodOverloading.runOverloadingClassMethods();
    }
}