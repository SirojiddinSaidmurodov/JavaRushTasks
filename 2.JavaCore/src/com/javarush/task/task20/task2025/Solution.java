package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.HashSet;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        HashSet<Long> result = new HashSet<>();

        for (long number = 1; number < N; number++) {
            byte[] digits = getDigits(number);
            if (isValid(digits)) {
                long sumOfPowers = sumOfPowers(digits);
                if (sumOfPowers == sumOfPowers(getDigits(sumOfPowers))) {
                    result.add(sumOfPowers);
                }
            }
        }
        return result.stream().sorted().mapToLong(i -> i).toArray();
    }

    private static boolean isValid(byte[] digits) {
        if (digits.length == 1) return true;
        for (byte i = 0; i < digits.length; i++) {
            if (i == 0) {
                if (digits[0] > digits[1]) {
                    return false;
                }
            } else if (i > 0 && i < digits.length - 1) {
                if (digits[i - 1] > digits[i] || digits[i] > digits[i + 1]) {
                    return false;
                }
            } else if (i == digits.length - 1) {
                if (digits[i - 1] > digits[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static long sumOfPowers(byte[] digits) {
        long sumOfPowers = 0;
        for (byte digit : digits) {
            sumOfPowers += Math.pow(digit, digits.length);
        }
        return sumOfPowers;
    }

    public static byte[] getDigits(long number) {
        int length = Long.toString(number).length();
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[length - 1 - i] = (byte) ((number % Math.pow(10, i + 1) - (number % Math.pow(10, i))) / Math.pow(10, i));
        }
        return result;
    }


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
    }
}
