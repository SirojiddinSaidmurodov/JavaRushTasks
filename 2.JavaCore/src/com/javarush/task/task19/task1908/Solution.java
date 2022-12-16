package com.javarush.task.task19.task1908;

/*
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputFile = consoleReader.readLine();
            String outputFile = consoleReader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile))) {
                try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile))) {
                    while (fileReader.ready()) {
                        for (String token : fileReader.readLine().split(" ")) {
                            if (token.matches("[0-9]+")) {
                                fileWriter.write(token + " ");
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
