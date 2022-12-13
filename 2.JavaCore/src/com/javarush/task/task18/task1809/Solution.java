package com.javarush.task.task18.task1809;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        byte[] data;
        try (FileInputStream file1 = new FileInputStream(file1Name)) {
            data = new byte[file1.available()];
            file1.read(data);
        }
        try (FileOutputStream file2 = new FileOutputStream(file2Name)) {
            for (int i = data.length - 1; i >= 0; i--) {
                file2.write(data[i]);
            }
        }
    }
}
