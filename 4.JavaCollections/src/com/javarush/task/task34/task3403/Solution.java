package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        new Solution().recurse(132);
        new Solution().recurse(-1);
        new Solution().recurse(256);
    }

    public void recurse(int n) {
        if (n <= 1) return;
        int divider = 2;
        while (n % divider != 0) {
            divider++;
        }
        System.out.print(divider);
        if (n / divider > 1) {
            System.out.print(" ");
            recurse(n / divider);
        }
    }
}
