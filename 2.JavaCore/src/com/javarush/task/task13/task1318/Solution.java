package com.javarush.task.task13.task1318;

/*
Чтение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));

            while (fileReader.ready()) {
                System.out.println(fileReader.readLine());
            }

            scanner.close();
            fileInputStream.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}