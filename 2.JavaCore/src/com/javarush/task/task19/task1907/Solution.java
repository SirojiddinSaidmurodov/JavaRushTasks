package com.javarush.task.task19.task1907;

/*
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int wordsCount = 0;
        try (FileReader reader = new FileReader(consoleReader.readLine())) {
            BufferedReader fileReader = new BufferedReader(reader);
            while (fileReader.ready()) {
                String input = fileReader.readLine();
                int initialCount = input.length();
                Pattern pattern = Pattern.compile("\\bworld\\b");
                Matcher matcher = pattern.matcher(input);
                while (matcher.find()) {
                    wordsCount++;
                }
            }
        }
        consoleReader.close();
        System.out.println(wordsCount);
    }
}
