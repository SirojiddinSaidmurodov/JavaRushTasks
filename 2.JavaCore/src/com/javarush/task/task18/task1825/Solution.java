package com.javarush.task.task18.task1825;

/*
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> files = new ArrayList<>();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line = consoleReader.readLine();
        while (!line.equals("end")) {
            files.add(line);
            line = consoleReader.readLine();
        }
        files.sort(String::compareTo);
        String outputFile = files.get(0).trim().replace(".part1", "");
        byte[] buffer;
        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            for (String file : files) {
                try (FileInputStream inputStream = new FileInputStream(file)) {
                    buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    outputStream.write(buffer);
                }
            }
        }

    }
}
