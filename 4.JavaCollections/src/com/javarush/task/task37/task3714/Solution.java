package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    private static final Map<String, Integer> singleRomanToArabicMap = new HashMap<>();
    private static final Map<String, Integer> pairRomanToArabicMap = new HashMap<>();

    static {
        singleRomanToArabicMap.put("I", 1);
        singleRomanToArabicMap.put("V", 5);
        singleRomanToArabicMap.put("X", 10);
        singleRomanToArabicMap.put("L", 50);
        singleRomanToArabicMap.put("C", 100);
        singleRomanToArabicMap.put("D", 500);
        singleRomanToArabicMap.put("M", 1000);
    }

    static {
        pairRomanToArabicMap.put("IV", 4);
        pairRomanToArabicMap.put("IX", 9);
        pairRomanToArabicMap.put("XL", 40);
        pairRomanToArabicMap.put("XC", 90);
        pairRomanToArabicMap.put("CD", 400);
        pairRomanToArabicMap.put("CM", 900);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        if (!s.matches("^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$")) {
            throw new NumberFormatException();
        }
        return parseRoman(s);
    }

    private static int parseRoman(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length()==1){
            return singleRomanToArabicMap.get(s);
        }
        else {
            if (pairRomanToArabicMap.containsKey(s.substring(0, 2))) {
                return pairRomanToArabicMap.get(s.substring(0, 2)) + parseRoman(s.substring(2));
            }
            return singleRomanToArabicMap.get(s.substring(0, 1)) + parseRoman(s.substring(1));
        }
    }
}
