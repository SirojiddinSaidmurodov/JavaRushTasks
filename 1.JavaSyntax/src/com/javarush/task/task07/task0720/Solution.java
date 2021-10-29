package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            strings.add(reader.readLine());
        }
        ArrayList<String> clone = (ArrayList<String>) strings.clone();
        List<String> range = clone.subList(0, M);
        strings.subList(0, M).clear();
        strings.addAll(range);
        for (String s :
                strings) {
            System.out.println(s);
        }

    }
}
