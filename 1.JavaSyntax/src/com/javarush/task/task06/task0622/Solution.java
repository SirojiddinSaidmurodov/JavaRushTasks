package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(Integer.parseInt(reader.readLine()));
        }
        arrayList.sort(Integer::compareTo);
        for (Integer i :
                arrayList) {
            System.out.println(i);
        }
    }
}
