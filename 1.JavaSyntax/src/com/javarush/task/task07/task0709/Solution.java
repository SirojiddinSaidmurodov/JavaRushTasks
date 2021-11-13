package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> input = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            input.add(reader.readLine());
            minlength = Math.min(input.get(i).length(), minlength);
        }
        for (int i = 0; i < 5; i++) {
            if (input.get(i).length() == minlength) {
                System.out.println(input.get(i));
            }
        }

    }
}
