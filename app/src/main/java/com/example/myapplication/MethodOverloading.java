package com.example.myapplication;

import android.util.Log;

/**
 * byte --> short --> int --> long --> float --> duble
 * char --> int
 * */
public class MethodOverloading {
    public static final String TAG = "mandal_MethodOverloading";
    public void runOverloadingClassMethods(){
        AutomaticPromotionInOverloading automaticPromotionInOverloading = new AutomaticPromotionInOverloading();
        automaticPromotionInOverloading.m1();
        automaticPromotionInOverloading.m1(1);
        automaticPromotionInOverloading.m1(1.2F);

        automaticPromotionInOverloading.m1();
        automaticPromotionInOverloading.m1('a'); // m1(int a)
        automaticPromotionInOverloading.m1(13l); // m1(float b)

        //case-2
        OverloadingCase2 overloadingCase2 = new OverloadingCase2();
        overloadingCase2.m1();
        overloadingCase2.m1(new Object());
        overloadingCase2.m1("test");

        overloadingCase2.m1();
        overloadingCase2.m1(null); // always Child class will get chance. if Child not there then Object(parent)

        //case-3
        OverloadingCase3 overloadingCase3 = new OverloadingCase3();
        overloadingCase3.m1();
        overloadingCase3.m1("test");
        overloadingCase3.m1(new StringBuffer("string buffer"));
        // overloadingCase3.m1(null);
        // 1. Reference is to m1 is ambiguous
        // 2.Compiler confused as String & StringBuffer both ar independent and null is for both. So compilation issue

        OverloadingCase4 overloadingCase4 = new OverloadingCase4();
        overloadingCase4.m1(); // m1(int... a) will get called as it supports from 0 to all
        overloadingCase4.m1(10,20);
        overloadingCase4.m1(10); // 1.0 -> 1.5old is gold m1(int a) will get called
    }

}

class AutomaticPromotionInOverloading{
    public static final String TAG = "mandal_MethodOverloading";

    public void m1(){
        Log.i(TAG,"case1: method m1");
    }

    public void m1(int a){
        Log.i(TAG,"case1: method m1 int a: "+a);
    }
    public void m1(float b){
        Log.i(TAG,"case1: method m1 float b: "+b);
    }
}

class OverloadingCase2{
    public static final String TAG = "mandal_MethodOverloading";

    public void m1(){
        Log.i(TAG,"case2: method m1");
    }

    public void m1(String a){
        Log.i(TAG,"case2: method m1 string a: "+a);
    }
    public void m1(Object b){
        Log.i(TAG,"case2: method m1 Object b: "+b);
    }
}
class OverloadingCase3{
    public static final String TAG = "mandal_MethodOverloading";

    public void m1(){
        Log.i(TAG,"case3: method m1");
    }

    public void m1(String a){
        Log.i(TAG,"case3: method m1 string a: "+a);
    }
    public void m1(StringBuffer b){
        Log.i(TAG,"case3: method m1 StringBuffer b: "+b);
    }
}
class OverloadingCase4{
    public static final String TAG = "mandal_MethodOverloading";

    public void m1(int a){
        Log.i(TAG,"case4: method m1 int a: "+a);
    }
    public void m1(int... b){
        Log.i(TAG,"case4: method m1 int... b: "+b);
    }
}

