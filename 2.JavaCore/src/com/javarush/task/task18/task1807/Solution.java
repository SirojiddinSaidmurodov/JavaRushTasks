package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commaCount = 0;
        try {
            String fileName = reader.readLine();
            try (FileInputStream inputStream = new FileInputStream(fileName)) {

                while (inputStream.available() > 0) {
                    if (',' == inputStream.read()) {
                        commaCount++;
                    }
                }
            }
            System.out.println(commaCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
