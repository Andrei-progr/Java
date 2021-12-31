package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        HashSet set = new HashSet();
        set.add("Руддщ");
        set.add("Hello");
        set.add("World");
        set.add("Summer");

        set.print();

        set.remove("Hello");
        set.remove("wwefwegwe");

        set.print();


        HashMap map = new HashMap();
        map.put(132,"Руддщ");
        map.put(54,"Hello");
        map.put(656,"World");
        map.put(1,"Summer");

        set.print();

        map.remove(234234);

        map.print();



    }

}
