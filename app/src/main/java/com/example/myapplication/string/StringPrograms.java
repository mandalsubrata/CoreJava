package com.example.myapplication.string;

import android.util.Log;

import java.util.Arrays;
import java.util.Locale;

public class StringPrograms {
    public static final String TAG = "mandal_string";
    public static final String SampleString = "This is test program";

    public int countCharInString(){
        int count = 0;
        for (int i = 0; i<SampleString.length(); i++){
            if (SampleString.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }

    public boolean anagram(){
        String s1 = "Brag";
        String s2 = "Grab";
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() != s2.length()){
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if (Arrays.equals(ch1,ch2)){
            Log.i(TAG,s1 + " and "+s2 +" both are anagram");
            return true;
        }
        return false;
    }

    public void findDuplicateWordInString(){
        String[] str;
        String s = "Big black bug bit a big black dog on his big black nose";
        char[] ch = s.toCharArray();
        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) != ' '){

            }
        }
    }
}
