package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
                ArrayList<String> words = new ArrayList<>();
                while (fileReader.ready()) {
                    String[] line = fileReader.readLine().split(" ");
                    for (String word : line) {
                        if (word.length() > 6) {
                            words.add(word);
                        }
                    }
                }
                for (int i = 0; i < words.size(); i++) {
                    fileWriter.write(words.get(i));
                    if (i != words.size() - 1) {
                        fileWriter.write(",");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
