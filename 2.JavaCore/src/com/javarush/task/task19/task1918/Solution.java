package com.javarush.task.task19.task1918;

/*
Знакомство с тегами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws RuntimeException {
        String file;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            file = consoleReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
