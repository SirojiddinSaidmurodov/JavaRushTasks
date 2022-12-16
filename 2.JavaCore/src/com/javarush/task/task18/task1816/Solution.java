package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int letterCount = 0;
        try {
            try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
                while (fileInputStream.available() > 0) {
                    int letter = fileInputStream.read();
                    if (('a' <= letter && letter <= 'z') || ('A' <= letter && letter <= 'Z')) {
                        letterCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(letterCount);
    }
}
