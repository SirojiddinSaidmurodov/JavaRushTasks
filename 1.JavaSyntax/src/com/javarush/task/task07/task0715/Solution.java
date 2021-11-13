package com.javarush.task.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String line : new String[]{"мама", "мыла", "раму"}) {
            arrayList.add(line);
        }
        for (int i = 1; i < 6; i += 2) {
            arrayList.add(i, "именно");
        }
        for (String line : arrayList) {
            System.out.println(line);
        }
    }
}
