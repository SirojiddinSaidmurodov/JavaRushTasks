package com.javarush.task.task07.task0707;

/*
Что за список такой?
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        System.out.println(strings.size());
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
