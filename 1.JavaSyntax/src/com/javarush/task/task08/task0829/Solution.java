package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (!city.isEmpty()) {
                map.put(city, reader.readLine());
            } else {
                break;
            }
        }

        String city = reader.readLine();
        if (map.containsKey(city)) {
            System.out.println(map.get(city));
        }

    }
}
