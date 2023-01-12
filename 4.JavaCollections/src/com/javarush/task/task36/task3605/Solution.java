package com.javarush.task.task36.task3605;

import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        try (FileReader fileReader = new FileReader(args[0])) {
            int letter;
            while ((letter = fileReader.read()) != -1) {
                if (Character.isAlphabetic(letter)) {
                    set.add(Character.toLowerCase((char) letter));
                }
            }
        }
        set.stream().sorted().limit(5).forEach(System.out::print);
    }
}
