package com.javarush.task.task20.task2009;

/*
Как сериализовать static?
*/

import java.io.Serializable;

public class Solution {
    public static void main(String[] args) {

    }

    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }
}
