package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] input = new String[10];
        int[] stringLen = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            input[i] = reader.readLine();
            stringLen[i] = input[i].length();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stringLen[i]);
        }
    }
}
