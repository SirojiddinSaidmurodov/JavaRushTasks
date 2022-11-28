package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        URL url = new URL(input);
        String query = url.getQuery();
        if (query.contains("obj")) {
            printParamNames(query);

            for (String s : query.split("&")) {
                if (s.contains("obj")) {
                    String[] param = s.split("=");
                    try {
                        alert(Double.parseDouble(param[1]));
                    } catch (NumberFormatException e) {
                        alert(param[1]);
                    }
                }
            }

        } else {
            printParamNames(query);
        }

    }

    public static void printParamNames(String query) {
        String[] paramsWithValues = query.split("&");
        for (String paramWithValue : paramsWithValues) {
            System.out.print(paramWithValue.split("=")[0] + " ");
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
