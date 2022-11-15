package com.javarush.task.task09.task0921;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        while (true) {
            try {
                numberList.add(scanner.nextInt());
            } catch (InputMismatchException e) {
                numberList.forEach(integer -> System.out.println(integer.toString()));
                break;
            }
        }
    }
}
