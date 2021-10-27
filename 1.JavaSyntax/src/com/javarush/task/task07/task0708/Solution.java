package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        Integer max = strings.stream().map(String::length).max(Integer::compareTo).get();
        ArrayList<String> result = (ArrayList<String>) strings.stream().filter(s -> s.length() == max).collect(Collectors.toList());
        for (String s :
                result) {
            System.out.println(s);
        }
    }
}
