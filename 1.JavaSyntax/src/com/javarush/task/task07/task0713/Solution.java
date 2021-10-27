package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> dividedBy3 = new ArrayList<>();
        ArrayList<Integer> dividedBy2 = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            in.add(Integer.parseInt(reader.readLine()));
        }
        for (int i : in) {
            if (i % 2 == 0 || i % 3 == 0) {
                if (i % 3 == 0) {
                    dividedBy3.add(i);
                }
                if (i % 2 == 0) {
                    dividedBy2.add(i);
                }
            } else {
                other.add(i);
            }
        }
        printList(dividedBy3);
        printList(dividedBy2);
        printList(other);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }
}
