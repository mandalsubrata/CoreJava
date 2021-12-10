package com.example.myapplication;

import android.util.Log;

import java.util.Optional;

public class OptionalConcept {
    public static final String TAG = "mandal";

    public void showOptionalFunction(){
        Customer customer1 = new Customer("mandal","mandal@abc.com", 100);
        Customer customer2 = new Customer("mandal",null, 100);

        Optional<Object> empty = Optional.empty();
        final Optional<String> emailOptional = Optional.of(customer1.email);
        final Optional<Integer> id1 = Optional.of(customer1.id);
        Log.i(TAG,"empty- "+empty
        + " emailOptional- "+emailOptional
        + " id- "+id1);

        Optional<Object> emptyNull = Optional.empty();
        final Optional<String> emailOptionalNull = Optional.ofNullable(customer2.email);
        final Optional<Integer> id2 = Optional.ofNullable(customer2.id);
        Log.i(TAG,"emptyNull- "+emptyNull
                + " emailOptionalNull- "+emailOptionalNull.orElse("default@abc.com")
                + " id- "+id2); // Null pointer exception will come


    }


    public class Customer {
        private String name;
        private String email;
        private int id;
        Customer(String name, String email, int id){
            this.email = email;
            this.id = id;
            this.name = name;
        }
    }
}
