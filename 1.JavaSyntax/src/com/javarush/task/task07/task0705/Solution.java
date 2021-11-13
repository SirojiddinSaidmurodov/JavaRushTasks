package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = numbers[i];
            b[i] = numbers[i + 10];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(b[i]);
        }
    }
}
