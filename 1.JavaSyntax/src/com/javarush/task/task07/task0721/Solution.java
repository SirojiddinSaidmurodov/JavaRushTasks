package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) {
        int[] numbers = getInts();

        int maximum = numbers[0], minimum = numbers[0];
        for (int i = 0; i < 20; i++) {
            if (maximum < numbers[i]) {
                maximum = numbers[i];
            }
            if (minimum > numbers[i]) {
                minimum = numbers[i];
            }
        }

        System.out.print(maximum + " " + minimum);
    }

    public static int[] getInts() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++) {
            try {
                numbers[i] = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return numbers;
    }
}
