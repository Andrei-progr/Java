package com.company;
import collection.ArrayList;
import collection.LinkedList;

import java.sql.Array;

public class TestArrayList extends Tests{

    @Before
    public void before(){
        System.out.println("Array Before");
    }

    @After
    public void after(){
        System.out.println("Array After");
    }

    @Test
    public void TestArrayContain(){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            list.add(i);
        }
        for (int i = 0; i < 3; i++){
            Assert.assertTrue((i + 1) + ".TestArrayContain", list.contains(i));
        }

        Assert.assertTrue(Integer.toString(4) + ".TestArrayContain", !list.contains(12345));
    }

    @Test
    public void TestArrayIsEmpty(){
        ArrayList<Integer> list = new ArrayList<>();

        Assert.assertTrue(1 + ".TestArrayIsEmpty", list.isEmpty());

        list.add(12);
        list.add(11);

        Assert.assertTrue(2 + ".TestArrayIsEmpty", !list.isEmpty());
    }

    @Test
    public void TestArrayRemove(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(134);
        Assert.assertTrue(1 + ".TestArrayRemove", !list.remove(1));
        Assert.assertTrue(2 + ".TestArrayRemove", list.remove(134));
    }

    @Test
    public void TestArrayContainsAll(){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            list.add(i);
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(1);

        Assert.assertTrue(1 + ".TestArrayContainsAll", list.containsAll(l));
        l.add(19);
        Assert.assertTrue(2 + ".TestArrayContainsAll", !list.containsAll(l));
    }

}
