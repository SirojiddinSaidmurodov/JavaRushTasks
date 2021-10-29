package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Random random = new Random();
        Map<String, String> humans = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            humans.put("" + random.nextInt(100), "" + random.nextInt(100));
        }
        return humans;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int result = 0;
        for (String nameFromMap : map.values()) {
            if (nameFromMap.equals(name)) {
                result++;
            }
        }
        return result;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        Set<String> lastNames = map.keySet();
        if (lastNames.contains(lastName)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
