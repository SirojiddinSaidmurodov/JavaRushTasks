package com.javarush.task.task19.task1910;

/*
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String source = consoleReader.readLine();
            String target = consoleReader.readLine();
            try (BufferedReader sourceReader = new BufferedReader(new FileReader(source))) {
                try (BufferedWriter targetWriter = new BufferedWriter(new FileWriter(target))) {
                    while (sourceReader.ready()) {
                        targetWriter.write(sourceReader.readLine().replaceAll("\\p{Punct}", ""));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
