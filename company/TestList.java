package com.company;

import collection.LinkedList;

public class TestList extends Tests{

    @Before
    public void before(){
        System.out.println("List Before");
    }

    @After
    public void after(){
        System.out.println("List After");
    }

    @Test
    public void TestListContain(){
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 3; i++){
            list.add(i);
        }
        for (int i = 0; i < 3; i++){
            Assert.assertTrue((i + 1) + ".TestListContain", list.contains(i));
        }

        Assert.assertTrue(Integer.toString(4) + ".TestListContain", !list.contains(12345));
    }

    @Test
    public void TestListIsEmpty(){
        LinkedList<Integer> list = new LinkedList<>();

        Assert.assertTrue(1 + ".TestListIsEmpty", list.isEmpty());

        list.add(12);
        list.add(11);

        Assert.assertTrue(2 + ".TestListIsEmpty", !list.isEmpty());
    }

    @Test
    public void TestListRemove(){
        LinkedList<Integer> list = new LinkedList<>();

        list.add(134);
        Assert.assertTrue(1 + ".TestListRemove", !list.remove(1));
        Assert.assertTrue(2 + ".TestListRemove", list.remove(134));
    }

    @Test
    public void TestListContainsAll(){
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++){
            list.add(i);
        }
        LinkedList<Integer> l = new LinkedList<>();
        l.add(2);
        l.add(1);

        Assert.assertTrue(1 + ".TestListContainsAll", !list.containsAll(l));
        l.add(19);
        Assert.assertTrue(2 + ".TestListContainsAll", !list.containsAll(l));
    }
}
