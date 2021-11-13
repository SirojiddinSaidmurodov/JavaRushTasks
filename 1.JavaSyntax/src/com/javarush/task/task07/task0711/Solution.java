package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> input = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            input.add(reader.readLine());
        }
        for (int i = 0; i < 13; i++) {
            String temp = input.get(input.size() - 1);
            input.remove(input.size() - 1);
            input.add(0, temp);
        }
        for (String s : input) {
            System.out.println(s);
        }
    }
}
