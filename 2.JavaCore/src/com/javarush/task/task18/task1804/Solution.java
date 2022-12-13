package com.javarush.task.task18.task1804;

/*
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        int[] bytesCount = new int[256];
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                bytesCount[inputStream.read()] += 1;
            }
        }

        int minValue = Integer.MAX_VALUE;
        for (int count : bytesCount) {
            if (minValue > count && count > 0) minValue = count;
        }

        for (int i = 0; i < bytesCount.length; i++) {
            if (bytesCount[i] == minValue) System.out.print(i + " ");
        }

    }
}
