package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        while (!line.isEmpty()) {
            int id = Integer.parseInt(line);
            String name = reader.readLine();
            map.put(name, id);
            line = reader.readLine();
        }
        for (String key : map.keySet()) {
            System.out.println(map.get(key) + " " + key);
        }
    }
}
