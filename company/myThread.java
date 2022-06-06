package com.company;
import java.lang.reflect.Array;
import java.util.*;

public class myThread extends Thread {

    private final String word;
    public static ArrayDeque<Class<? extends Tests>> arr;

    static{
        arr = new ArrayDeque<>();
    }

    public static void load(Class<? extends Tests> t){
        arr.add(t);
    }

    public myThread(String word) {
        super(word);
        this.word = word;
    }

    public void delete() throws NoSuchElementException {
        Class<? extends Tests> c = arr.pop();
        System.out.println(word + " " + c.getName());
        Run runner = new Run(c);
        runner.runTest();
    }

    @Override
    public void run() {
        while(true) {
            try {
                delete();
            }catch(NoSuchElementException e){
                return;
            }
        }
    }
}



