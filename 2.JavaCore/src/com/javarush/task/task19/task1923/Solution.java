package com.javarush.task.task19.task1923;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
                while (reader.ready()) {
                    for (String word : reader.readLine().split(" ")) {
                        if (word.matches(".*[0-9].*")) {
                            writer.write(word + " ");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
