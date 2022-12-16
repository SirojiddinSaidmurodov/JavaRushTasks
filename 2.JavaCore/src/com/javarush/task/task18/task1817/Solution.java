package com.javarush.task.task18.task1817;

/*
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int spaces = 0, symbols = 0;
        try (FileInputStream inputStream = new FileInputStream(args[0])) {
            while (inputStream.available() > 0) {
                int input = inputStream.read();
                symbols++;
                if (input == ' ') {
                    spaces++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%.2f", (float) spaces / symbols * 100);
    }
}
