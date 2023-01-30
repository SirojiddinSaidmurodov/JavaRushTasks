package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (Math.abs(first.length() - second.length()) > 1) return false;
        if (first.length() + second.length() == 1) return true;
        if(first.equals(second)) return true;
        StringBuilder builderA;
        StringBuilder builderB;
        if (first.length() < second.length()) {
            builderA = new StringBuilder(first);
            builderB = new StringBuilder(second);
        } else {
            builderA = new StringBuilder(second);
            builderB = new StringBuilder(first);
        }
        int totalDiff = 0;
        if (first.length() == second.length()) {
            for (int i = 0; i < builderA.length(); i++) {
                if (builderA.charAt(i) != builderB.charAt(i)) {
                    totalDiff++;
                    if(totalDiff==2) break;
                }
            }
        } else {
            for (int i = 0; i < builderA.length(); i++) {
                if (builderA.charAt(i) != builderB.charAt(i)) {
                    totalDiff++;
                    if(totalDiff==2) break;
                    builderB.replace(i, i + 1, "");
                    i--;
                }
            }
        }
        return totalDiff <= 1;
    }

}
