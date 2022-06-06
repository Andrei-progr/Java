package com.company;
import collection.HashMap;

public class TestMap extends Tests{

    @Before
    public void before(){
        System.out.println("Map Before");
    }

    @After
    public void after(){
        System.out.println("Map After");
    }

    @Test
    public void TestMapGet(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(13, "value");
        Assert.assertEquals("TestMapGet", "value", map.get(13));
    }

    @Test
    public void TestMapContainsKey(){
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 2; i++){
            map.put(i, Integer.toString(i));
        }
        for (int i = 0; i < 2; i++){
            Assert.assertTrue((i + 1) + ".TestMapContainsKey", map.containsKey(i));
        }

        Assert.assertTrue(Integer.toString(4) + ".TestMapContainsKey", !map.containsKey(12345));
    }

    @Test
    public void TestMapContainsValue(){
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 3; i++){
            map.put(i, Integer.toString(i));
        }
        for (int i = 0; i < 2; i++){
            Assert.assertTrue((i + 1) + ".TestMapContainsValue", map.containsValue(Integer.toString(i)));
        }

        Assert.assertTrue(Integer.toString(4) + ".TestMapContainsValue", !map.containsValue("STRING"));
    }

}
