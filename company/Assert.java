package com.company;

public class Assert {

    public static void assertEquals(String functionName, Object expected, Object actual){
        if (isEquals(expected, actual)){
            System.out.println(functionName + ": Тест пройден успешно");
        }else{
            System.out.println(functionName + ": Тест провален!");
        }
    }

    private static boolean isEquals(Object expected, Object actual) {
        if (expected == null) {
            return actual == null;
        }else {
            return expected.equals(actual);
        }
    }

    public static void assertTrue(String message, boolean condition) {
        if (condition) {
            System.out.println(message + ": Тест пройден успешно");
        } else {
            System.out.println(message + ": Тест провален!");
        }
    }

    public static void assertNull(Object obj){
        if (obj == null){
            System.out.println("Тест пройден успешно");
        } else {
            System.out.println("Тест провален!");
        }
    }

    public static void assertNotNull(Object obj){
        if (obj != null){
            System.out.println("Тест пройден успешно");
        } else {
            System.out.println("Тест провален!");
        }
    }

}
