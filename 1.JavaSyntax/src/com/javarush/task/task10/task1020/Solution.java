package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 10 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        for (int i = array.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (array[j] < array[j - 1]) {
                    int A = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = A;
                }
            }
        }
    }
}
