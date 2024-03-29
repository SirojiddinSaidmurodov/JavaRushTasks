package com.javarush.task.task19.task1926;

/*
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String file = consoleReader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                while (fileReader.ready()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(fileReader.readLine());
                    System.out.println(stringBuilder.reverse());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
