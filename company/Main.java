package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        HashSet set = new HashSet();
        set.add("Kek");
        set.add("Kek");
        set.add("Lol");
        set.add("TRrtat");

        set.print();

        set.remove("Kek");
        set.remove("wdwfwf");

        set.print();



    }

}
