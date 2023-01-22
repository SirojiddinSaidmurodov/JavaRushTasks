package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object number = 15.f;
        Integer integer = (Integer) number;

    }

    public void methodThrowsNullPointerException() {
        Float number = null;
        number.byteValue();
    }

    public static void main(String[] args) {

    }
}
