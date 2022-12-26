package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{{1, 1, 0, 0}, {1, 1, 0, 0}, {1, 1, 0, 0}, {1, 1, 0, 1}};
        byte[][] a2 = new byte[][]{{1, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 1}};

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int result = 0;
        boolean[][] isCount = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1 && !isCount[i][j]) {
                    markUp(a, isCount, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void markUp(byte[][] square, boolean[][] isCount, int x, int y) {
        int deltaX = 0, deltaY = 0;
        for (int i = x; i < square.length; i++) {
            if (square[i][y] == 1) deltaX = i;
            else break;
        }
        for (int j = y; j < square[0].length; j++) {
            if (square[x][j] == 1) deltaY = j;
            else break;
        }
        for (int i = 0; i < isCount.length; i++) {
            for (int j = 0; j < isCount[0].length; j++) {
                if ((x <= i && i <= deltaX) && (y <= j && j <= deltaY)) isCount[i][j] = true;
            }
        }

    }
}
