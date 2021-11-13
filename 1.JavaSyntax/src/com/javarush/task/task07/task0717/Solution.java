package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> input = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            input.add(reader.readLine());
        }
        ArrayList<String> result = doubleValues(input);

        for (String line : result) {
            System.out.println(line);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();
        for (String line : list) {
            result.add(line);
            result.add(line);
        }
        return result;
    }
}
