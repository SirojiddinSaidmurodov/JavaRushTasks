package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            boolean isConvertibleToDouble;
            try {
                Double.parseDouble(input);
                isConvertibleToDouble = true;
            } catch (NumberFormatException e) {
                isConvertibleToDouble = false;
            }
            if (input.equals("exit")) {
                break;
            } else if (input.contains(".") && isConvertibleToDouble) {
                print(Double.parseDouble(input));
            } else {
                boolean isConvertible = false;
                try {
                    Integer.parseInt(input);
                    isConvertible = true;
                } catch (NumberFormatException e) {
                    print(input);
                }
                if (isConvertible) {
                    int inputNum = Integer.parseInt(input);
                    if (0 < inputNum && inputNum < 128) {
                        print(Short.parseShort(input));
                    } else {
                        print(inputNum);
                    }
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
