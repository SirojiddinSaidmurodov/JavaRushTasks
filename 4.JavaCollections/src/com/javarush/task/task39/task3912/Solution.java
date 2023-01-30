package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] dp = new int[rows + 1][columns + 1];
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = 1 + min(dp[i][j], dp[i + 1][j], dp[i][j + 1]);
                    maxSide = Math.max(maxSide,dp[i+1][j+1]);
                }
            }
        }
        return maxSide*maxSide;
    }


    private static int min(int... a) {
        int min = Integer.MAX_VALUE;
        for (int i : a) {
            if (i < min) min = i;
        }
        return min;
    }
}
