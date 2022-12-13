package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int min = Integer.MAX_VALUE;
        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            if (currentByte < min) {
                min = currentByte;
            }
        }
        fileInputStream.close();
        System.out.println(min);
    }
}
