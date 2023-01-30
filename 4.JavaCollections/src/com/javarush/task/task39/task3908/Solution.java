package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        Map<Byte, Integer> frequencyMap = getFrequencyMap(s);
        return canMakePalindrome(frequencyMap);
    }

    private static boolean canMakePalindrome(Map<Byte, Integer> frequencyMap) {
        boolean canMakePalindrome = true;
        boolean isOdd = false;
        for (Byte b : frequencyMap.keySet()) {
            if (frequencyMap.get(b) % 2 == 1) {
                if (isOdd) {
                    canMakePalindrome = false;
                    break;
                } else {
                    isOdd = true;
                }
            }
        }
        return canMakePalindrome;
    }

    private static Map<Byte, Integer> getFrequencyMap(String s) {
        byte[] bytes = s.toLowerCase().getBytes();
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : bytes) {
            if (frequencyMap.containsKey(b)) {
                frequencyMap.put(b, frequencyMap.get(b) + 1);
            } else {
                frequencyMap.put(b, 1);
            }
        }
        return frequencyMap;
    }
}
