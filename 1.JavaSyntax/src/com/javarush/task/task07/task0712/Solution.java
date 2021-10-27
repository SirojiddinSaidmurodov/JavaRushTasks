package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> in = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            in.add(reader.readLine());
        }
        int maxInd = 0;
        int minInd = 0;
        int maxLen = in.get(0).length();
        int minLen = in.get(0).length();
        for (int i = 0; i < 10; i++) {
            int length = in.get(i).length();
            if (length > maxLen) {
                maxInd = i;
                maxLen = length;
            }
            if (length < minLen) {
                minInd = i;
                minLen = length;
            }
        }
        System.out.println(maxInd < minInd ? in.get(maxInd) : in.get(minInd));

    }
}
