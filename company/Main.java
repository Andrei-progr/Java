package com.company;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Throwable {

        Class<TestMath> c = TestMath.class;
        Class<TestArrayList> arr = TestArrayList.class;
        Class<TestMap> m = TestMap.class;
        Class<TestList> d = TestList.class;

        myThread.load(c);
        myThread.load(arr);
        myThread.load(m);
        myThread.load(d);

        int N = Integer.getInteger(args[0]);

        myThread[] threads = new myThread[N];

        for (int i = 0; i < N; i++){
          threads[i] = new myThread("thread " + i);
        }

        for (Thread t : threads){
             t.start();
        }
    }
}
