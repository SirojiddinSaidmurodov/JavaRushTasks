package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            result.put(Integer.toString(i), i * 100);
        }
        return result;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        List<String> blacklist = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 500) {
                blacklist.add(entry.getKey());
            }
        }
        for (String key : blacklist) {
            map.remove(key);
        }
    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());
    }
}