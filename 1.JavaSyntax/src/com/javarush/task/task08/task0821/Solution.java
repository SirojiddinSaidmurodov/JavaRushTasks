package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String,String> namesSurnames = new HashMap<>();
        namesSurnames.put("1","9");
        namesSurnames.put("1","8");
        namesSurnames.put("2","7");
        namesSurnames.put("3","6");
        namesSurnames.put("4","5");
        namesSurnames.put("5","4");
        namesSurnames.put("6","3");
        namesSurnames.put("7","2");
        namesSurnames.put("8","1");
        namesSurnames.put("9","1");

        return namesSurnames;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
