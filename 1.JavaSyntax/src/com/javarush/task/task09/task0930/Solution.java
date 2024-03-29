package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        while (!line.isEmpty()) {
            list.add(line);
            line = reader.readLine();
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = i;
            if (isNumber(array[i])) {
                for (int s = i - 1; s >= 0; s--) {
                    if (isNumber(array[s])) {
                        if (Integer.parseInt(array[current]) > Integer.parseInt(array[s])) {
                            String temp;
                            temp = array[current];
                            array[current] = array[s];
                            array[s] = temp;
                            current = s;
                        }
                    }
                }
            } else {
                for (int s = i - 1; s >= 0; s--) {
                    if (!isNumber(array[s])) {
                        if (isGreaterThan(array[s], array[current])) {
                            String temp;
                            temp = array[current];
                            array[current] = array[s];
                            array[s] = temp;
                            current = s;
                        }
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}
