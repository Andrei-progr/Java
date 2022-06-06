package com.company;

import com.company.Assert;
import com.company.Test;

import java.lang.annotation.Target;


public class TestMath extends Tests{

    @Before
    public void before(){
        System.out.println("Math Before");
    }

    @com.company.After
    public void after(){
        System.out.println("Math After");
    }


    @Test
    public void TestAdd() {
        int b = 10;
        int c = 20;
        int a = c + b;
        Assert.assertEquals("TestAdd", a, 30);
    }

    @Test(expected = ArithmeticException.class)
    public void TestDiv(){
        Math m = new Math();
        int a = m.div(10, 0);
        Assert.assertEquals("TestDiv", a, 2);
    }

    @Test
    public void TestDiv2(){
        Math m = new Math();
        int a = m.div(10, 5);
        Assert.assertEquals("TestDiv2", a, 2);
    }

    @Test
    public void isNull(){
        Assert.assertNull(null);
    }


}
