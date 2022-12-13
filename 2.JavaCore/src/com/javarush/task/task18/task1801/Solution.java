package com.javarush.task.task18.task1801;

/*
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(filename);
        int max = Integer.MIN_VALUE;
        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            if (currentByte > max) max = currentByte;
        }
        fileInputStream.close();
        System.out.println(max);
    }
}
