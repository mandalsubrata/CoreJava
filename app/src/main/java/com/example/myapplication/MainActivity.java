package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mandal_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public int age() {
                Log.i(TAG,"age called from MainActivity");
                return 0;
            }
        };
        abstractClass.age();

        Man man = new Man();
        man.age();
        man.showHand();
        man.test();

     //   ThreadClass thread = new ThreadClass();
     //   thread.showNaturalNumber();

     //   ConsumerProducer consumerProducer = new ConsumerProducer();
     //   consumerProducer.ConsumeAndProduce();

     //   CProducerThreadExecutor cProducerThreadExecutor = new CProducerThreadExecutor();
     //   cProducerThreadExecutor.runExecutorProgram();

        OptionalConcept optionalConcept = new OptionalConcept();
        optionalConcept.showOptionalFunction();

    }
}