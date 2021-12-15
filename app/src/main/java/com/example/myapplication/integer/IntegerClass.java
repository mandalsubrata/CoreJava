package com.example.myapplication.integer;

public class IntegerClass {
    public void printAllDigitsInInteger(int n) {
        int len = 0;
        int m = n;
        while(m>0) {
            m = m / 10;
            len++;
        }

        int[] intArray = new int[len];
        for(int i=0; i<len;i++){
            intArray[i] = n%10;
            System.out.println(i+1+ "- "+intArray[i]);
            n = n/10;
        }
    }
}
