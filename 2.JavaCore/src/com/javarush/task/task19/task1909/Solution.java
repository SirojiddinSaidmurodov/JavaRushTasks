package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String source = consoleReader.readLine();
            String target = consoleReader.readLine();
            ArrayList<String> content = readContent(source);

            List<String> result = content.stream().map(s -> s.replaceAll("\\.", "!")).collect(Collectors.toList());

            writeResult(target, result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static ArrayList<String> readContent(String source) throws IOException {
        ArrayList<String> content = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(source))) {
            while (fileReader.ready()) {
                content.add(fileReader.readLine());
            }
        }
        return content;
    }

    private static void writeResult(String target, List<String> result) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(target))) {
            for (String line : result) {
                fileWriter.write(line + "\n");
            }
        }
    }
}
