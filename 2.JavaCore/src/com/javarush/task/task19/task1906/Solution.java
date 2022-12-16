package com.javarush.task.task19.task1906;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String source = consoleReader.readLine();
        String target = consoleReader.readLine();

        consoleReader.close();
        try (FileReader sourceReader = new FileReader(source)) {
            try (FileWriter targetWriter = new FileWriter(target)) {
                int i = 1;
                while (sourceReader.ready()) {
                    int input = sourceReader.read();
                    if (i % 2 == 0) {
                        targetWriter.write(input);
                    }
                    i++;
                }
            }
        }

    }
}
