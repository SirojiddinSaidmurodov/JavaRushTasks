package com.javarush.task.task18.task1805;

/*
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<Integer> bytes = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int input = inputStream.read();
                if (!bytes.contains(input)) {
                    bytes.add(input);
                }
            }
        }
        bytes.sort(Integer::compare);
        for (Integer aByte : bytes) {
            System.out.print(aByte + " ");
        }
    }
}
