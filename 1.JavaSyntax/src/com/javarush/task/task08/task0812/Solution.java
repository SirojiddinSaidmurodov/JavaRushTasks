package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        Integer currentNumber = null;
        int maxChain = 0;
        int currentChain = 0;
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(reader.readLine());
            numbers.add(number);

            if (currentNumber == null) {
                currentNumber = number;
                currentChain++;
            } else {
                if (currentNumber == number) {
                    currentChain++;
                    if (i == 9) {
                        if (currentChain > maxChain) {
                            maxChain = currentChain;
                        }
                    }
                } else {
                    if (currentChain > maxChain) {
                        maxChain = currentChain;
                    }
                    currentChain = 1;
                    currentNumber = number;
                }
            }
        }

        System.out.println(maxChain);
    }
}
