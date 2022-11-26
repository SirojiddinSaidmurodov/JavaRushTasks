package com.javarush.task.task14.task1420;

/*
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int m, n;

        m = scanner.nextInt();
        n = scanner.nextInt();
        System.out.println(gcd(m, n));
    }

    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

}
