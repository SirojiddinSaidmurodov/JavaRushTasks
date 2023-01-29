package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null) return 0;
        StringBuilder buffer = new StringBuilder();
        int maxLength = 0;
        for (char c : s.toCharArray()) {
            if (buffer.toString().contains(Character.toString(c))) {
                trimBufferToMakeSequenceUnique(buffer, c);
            } else {
                buffer.append(c);
                if (maxLength < buffer.length()) {
                    maxLength = buffer.length();
                }
            }
        }

        return maxLength;
    }

    private static void trimBufferToMakeSequenceUnique(StringBuilder buffer, char c) {
        int startIndex = buffer.indexOf(Character.toString(c));
        buffer.replace(0, startIndex, "");
    }
}
