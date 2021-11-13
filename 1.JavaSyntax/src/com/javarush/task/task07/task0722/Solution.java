package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> input = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String line = reader.readLine();
            if (!line.equals("end")) {
                input.add(line);
            } else {
                break;
            }
        }
        for (String line : input) {
            System.out.println(line);
        }

    }
}