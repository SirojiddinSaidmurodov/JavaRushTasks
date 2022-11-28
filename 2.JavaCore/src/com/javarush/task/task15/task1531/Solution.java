package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
        long start = System.nanoTime();
        factorial(input);
        long end = System.nanoTime();
        System.out.println(end - start);
        start = System.nanoTime();
        recFactorial(input);
        end = System.nanoTime();
        System.out.println(end - start);
    }

    public static BigInteger factorial(int n) {
        if (n < 0) return BigInteger.valueOf(0);
        if (n == 0) return BigInteger.valueOf(1);
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger recFactorial(int n) {
        if (n < 0) return BigInteger.valueOf(0);
        if (n == 0) return BigInteger.valueOf(1);
        return recFactorial(n - 1).multiply(BigInteger.valueOf(n));
    }
}
