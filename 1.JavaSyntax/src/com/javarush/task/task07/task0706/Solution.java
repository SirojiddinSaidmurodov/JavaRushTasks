package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] input = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int even = 0, odd = 0;

        for (int i = 0; i < 15; i++) {
            input[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) {
                even += input[i];
            } else {
                odd += input[i];
            }
        }
        if (even != odd) {
            if (odd > even) {
                System.out.println("В домах с нечетными номерами проживает больше жителей.");
            } else {
                System.out.println("В домах с четными номерами проживает больше жителей.");
            }
        }

    }
}
