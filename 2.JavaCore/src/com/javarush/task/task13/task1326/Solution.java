package com.javarush.task.task13.task1326;

/*
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ArrayList<Integer> integers = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
        while (fileReader.ready()) {
            int nextInt = Integer.parseInt(fileReader.readLine());
            if (nextInt % 2 == 0) {
                integers.add(nextInt);
            }
        }
        fileInputStream.close();
        integers.sort(Integer::compareTo);
        integers.forEach(System.out::println);

    }
}
