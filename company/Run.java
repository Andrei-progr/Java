package com.company;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

public class Run {

    private final Class<? extends Tests> c;

    private final LinkedList<Method> after;
    private final LinkedList<Method> before;
    private final LinkedList<Method> test;

    public Run(Class<? extends Tests> c){
        this.c = c;
        after = new LinkedList<>();
        before = new LinkedList<>();
        test = new LinkedList<>();
    }

    public void runTest(){

        Method[] m = c.getDeclaredMethods();

        for (Method me : m) {
            try {
                Annotation anno = me.getDeclaredAnnotations()[0];
                if (anno.annotationType().getName().equals("com.company.Test")) {
                    test.add(me);
                }
                if (anno.annotationType().getName().equals("com.company.After")) {
                    after.add(me);
                }
                if (anno.annotationType().getName().equals("com.company.Before")) {
                    before.add(me);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.fillInStackTrace();
            }
        }
        try {
            executeTests();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void executeTests() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        for (Method m : test){
            Constructor<?>[] con = c.getDeclaredConstructors();
            Object obj = con[0].newInstance();

            executeBefore(obj);
            try {
                m.invoke(obj);
            }catch(InvocationTargetException ex){
                if (getExpected(m).equals(ex.getCause().getClass().getName())){
                    System.out.println(m.getName() + ": Тест пройден успешно, сработало ожидаемое исключение");
                }else{
                    ex.getCause().printStackTrace();
                    System.out.println(m.getName() + ": Тест провален!");
                }
            }
            executeAfter(obj);
        }
    }

    private void executeBefore(Object obj) throws InvocationTargetException, IllegalAccessException {
        for (Method m : before){
            m.invoke(obj);
        }
    }

    private void executeAfter(Object obj) throws InvocationTargetException, IllegalAccessException {
        for (Method m : after){
            m.invoke(obj);
        }
    }

    private String getExpected(Method m) {
        Annotation anno = m.getDeclaredAnnotations()[0];
        Test t = (Test) anno;
        Class<? extends Throwable> exCls = t.expected();

        return exCls.getName();
    }
}
