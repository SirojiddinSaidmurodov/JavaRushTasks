package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(Integer.toString(i), Integer.toString(i));
        }
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        ArrayList<String> list = new ArrayList<>(map.values());
        for (String element : list) {
            if (!values.add(element))
                removeItemFromMapByValue(map, element);
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
}
